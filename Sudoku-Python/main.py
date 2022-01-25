import copy

import pygame
import sudoku
import time

pygame.init()
# create screen
screen = pygame.display.set_mode((800, 600))

# title and icon
pygame.display.set_caption("Sudoku")
icon = pygame.image.load("images/sudoku.png")
pygame.display.set_icon(icon)

start_img = pygame.image.load('images/play-button.png').convert_alpha()
exit_img = pygame.image.load('images/power-button.png').convert_alpha()
back_img = pygame.image.load('images/back-button.png').convert_alpha()
solve_img = pygame.image.load('images/shuttle.png').convert_alpha()
rewind_img = pygame.image.load('images/rewind-button.png').convert_alpha()
help_img = pygame.image.load('images/help-button.png').convert_alpha()


# button class
class Button():
    def __init__(self, x, y, image, scale):
        width = image.get_width()
        height = image.get_height()
        self.image = pygame.transform.scale(image, (int(width * scale), int(height * scale)))
        self.rect = self.image.get_rect()
        self.rect.topleft = (x, y)
        self.clicked = False

    def draw(self):
        action = False
        # get mouse position//+
        pos = pygame.mouse.get_pos()
        # print(pos)
        # check mouseover and clicked conditions
        if self.rect.collidepoint(pos):
            if pygame.mouse.get_pressed()[0] == 1 and self.clicked == False:
                # print('click')
                self.clicked = True
                action = True
        if pygame.mouse.get_pressed()[0] == 0:
            self.clicked = False
        # draw button on the screen
        screen.blit(self.image, (self.rect.x, self.rect.y))
        return action


# create button instances
start_button = Button(400, 250, start_img, 1.5)
exit_button = Button(400, 300, exit_img, 1.5)
exit_button2 = Button(100, 550, exit_img, 1.5)
easy_button = Button(430, 200, start_img, 1.5)
medium_button = Button(470, 250, start_img, 1.5)
hard_button = Button(430, 300, start_img, 1.5)
back_button = Button(50, 553, back_img, 1)
help_button = Button(750, 50, help_img, 1.5)
backh_button = Button(700, 550, back_img, 1)

solveDFS_button = Button(700, 50, solve_img, 1.5)
solveBFS_button = Button(700, 120, solve_img, 1.5)
solveuni_button = Button(700, 190, solve_img, 1.5)
solveas_button = Button(700, 260, solve_img, 1.5)
solveas2_button = Button(700, 330, solve_img, 1.5)
solveas3_button = Button(700, 400, solve_img, 1.5)

rewind_button = Button(150, 550, rewind_img, 1.5)

start_button_pressed = False
help_button_pressed = False
easy = False
medium = False
hard = False
game_started = False

font = pygame.font.Font(pygame.font.get_default_font(), 30)
b1 = copy.deepcopy(sudoku.board_easy)
b2 = copy.deepcopy(sudoku.board_medium)
b3 = copy.deepcopy(sudoku.board_hard)
# sudoku variables*
apasat = False

be = copy.deepcopy(sudoku.board_easy)
bm = copy.deepcopy(sudoku.board_medium)
bh = copy.deepcopy(sudoku.board_hard)
bf = []

bg = pygame.image.load('images/flying-numbers.jpg')
bg2 = pygame.image.load('images/flying-numbers2.jpg')
bg3 = pygame.image.load('images/flying-numbers3.jpg')
bgs = pygame.image.load('images/start_image.jpg')
bgn = pygame.image.load('images/nivele.jpg')
bgh = pygame.image.load('images/helpinfo.jpg')


def show_text(t, x, y):
    text = font.render(t, True, (0, 0, 0))
    screen.blit(text, (x, y))


def show_text2(t, x, y):
    text = font.render(t, True, (181, 59, 20))
    screen.blit(text, (x, y))


def show_text3(t, x, y):
    text = font.render(t, True, (252, 118, 0))
    screen.blit(text, (x, y))


# Game Loop
running = True
l = 0
while running:

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # prima pagina
    screen.blit(bgs, (0, 0))
    if start_button_pressed == False and help_button_pressed == False and start_button.draw():
        print('Start')
        start_button_pressed = True
    if start_button_pressed == False and help_button_pressed == False and exit_button.draw():
        print('Exit')
        running = False
    if start_button_pressed == False and help_button_pressed == False and help_button.draw():
        print('help')
        help_button_pressed = True
    # pagina help
    if help_button_pressed == True:
        screen.blit(bgh, (0, 0))
        if backh_button.draw():
            help_button_pressed = False
    # show_text("nou",10,10)
    # pagina cu nivelurile
    if start_button_pressed and game_started == False:
        screen.blit(bgn, (0, 0))
        show_text("easy", 350, 200)
        show_text("medium", 350, 250)
        show_text("hard", 350, 300)
    # easy_button.draw()
    # medium_button.draw()
    # hard_button.draw()
    if start_button_pressed and game_started == False and easy_button.draw():
        easy = True
        game_started = True
    if start_button_pressed and game_started == False and medium_button.draw():
        medium = True
        game_started = True
    if start_button_pressed and game_started == False and hard_button.draw():
        hard = True
        game_started = True
    if start_button_pressed and game_started == False and exit_button2.draw():
        running = False

    # pagina cu jocul propriu-zis in functie de nivelul ales
    if game_started:
        if easy:
            screen.blit(bg, (0, 0))
        elif medium:
            screen.blit(bg2, (0, 0))
        elif hard:
            screen.blit(bg3, (0, 0))
        # apasat=False
        if exit_button2.draw():
            running = False
        if back_button.draw():
            sudoku.board_frames = []
            game_started = False
            easy = False
            medium = False
            hard = False
            sudoku.refreshCostMatrix()
            bf = []
            l = 0
        if rewind_button.draw():
            sudoku.board_frames = []
            sudoku.board_easy = b1
            sudoku.board_medium = b2
            sudoku.board_hard = b3
            sudoku.refreshCostMatrix()
            bf = []
            l = 0
        if solveDFS_button.draw():

            if easy:
                sudoku.board_frames = []
                sudoku.board_easy = sudoku.DFS(sudoku.board_easy, 1)
                bf = copy.deepcopy(sudoku.board_frames)
                # print(len(sudoku.board_frames))
                print("-> DFS easy")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
            if medium:
                sudoku.board_medium = sudoku.DFS(sudoku.board_medium, 2)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> DFS meidum")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
            if hard:
                sudoku.board_hard = sudoku.DFS(sudoku.board_hard, 3)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> DFS hard")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
        if solveBFS_button.draw():
            if easy:
                sudoku.board_easy = sudoku.BFS(sudoku.board_easy, 1)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> BFS easy")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
            if medium:
                sudoku.board_medium = sudoku.BFS(sudoku.board_medium, 2)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> BFS medium")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
            if hard:
                sudoku.board_hard = sudoku.BFS(sudoku.board_hard, 3)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> BFS hard")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
        if solveuni_button.draw():
            if easy:
                sudoku.board_easy, cost = sudoku.UniformSearch(sudoku.board_easy, 1)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> UNIFORM SEARCH easy")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
            if medium:
                sudoku.board_medium, cost = sudoku.UniformSearch(sudoku.board_medium, 2)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> UNIFORM SEARCH medium")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
            if hard:
                sudoku.board_hard, cost = sudoku.UniformSearch(sudoku.board_hard, 3)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> UNIFORM SEARCH hard")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
        if solveas_button.draw():
            if easy:
                sudoku.board_easy, cost = sudoku.AS(sudoku.board_easy, 1)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> A* with the null heuristic easy")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
            if medium:
                sudoku.board_medium, cost = sudoku.AS(sudoku.board_medium, 2)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> A* with the null heuristic medium")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
            if hard:
                sudoku.board_hard, cost = sudoku.AS(sudoku.board_hard, 3)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> A* with the null heuristic hard")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
        if solveas2_button.draw():
            if easy:
                sudoku.board_easy, cost = sudoku.AS2(sudoku.board_easy, 1)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> A* with the second heuristic easy")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
            if medium:
                sudoku.board_medium, cost = sudoku.AS2(sudoku.board_medium, 2)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> A* with the second heuristic medium")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
            if hard:
                sudoku.board_hard, cost = sudoku.AS2(sudoku.board_hard, 3)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> A* with the second heuristic hard")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
        if solveas3_button.draw():
            if easy:
                sudoku.board_easy, cost = sudoku.AS3(sudoku.board_easy, 1)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> A* with the third heuristic easy")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
            if medium:
                sudoku.board_medium, cost = sudoku.AS3(sudoku.board_medium, 2)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> A* with the third heuristic medium")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
            if hard:
                sudoku.board_hard, cost = sudoku.AS3(sudoku.board_hard, 3)
                bf = copy.deepcopy(sudoku.board_frames)
                print("-> A* with the third heuristic hard")
                print(sudoku.board_frames)
                print("pasi:", len(sudoku.board_frames))
                print("cost: ", cost)
        show_text("DFS", 620, 55)
        show_text("BFS", 620, 125)
        show_text("Uniform", 570, 185)
        show_text("Search", 570, 215)
        show_text("A*", 650, 265)
        show_text("A* 2", 620, 335)
        show_text("A* 3", 620, 405)

    if easy:
        for i in range(0, 5):
            if (i % 2 == 0):
                pygame.draw.line(screen, (181, 59, 20), (50 + 50 * i, 50), (50 + 50 * i, 250), 5)
                pygame.draw.line(screen, (181, 59, 20), (50, 50 + 50 * i), (250, 50 + 50 * i), 5)
            else:
                pygame.draw.line(screen, (181, 59, 20), (50 + 50 * i, 50), (50 + 50 * i, 250), 2)
                pygame.draw.line(screen, (181, 59, 20), (50, 50 + 50 * i), (250, 50 + 50 * i), 2)
        if l < (len(bf)):
            for i in range(0, 4):
                for j in range(0, 4):
                    if (bf[l][i][j] != 0):
                        if b1[i][j] == 0:
                            show_text3(str(bf[l][i][j]), 70 + 50 * j, 60 + 50 * i)
                        else:
                            show_text2(str(bf[l][i][j]), 70 + 50 * j, 60 + 50 * i)

            if (l < len(bf) - 1):

                # solving.draw()
                screen.fill((255, 0, 0), rect=[200, 550, 20, 30])
            else:
                # doneb.draw()
                screen.fill((252, 225, 0), rect=[200, 550, 20, 30])
            pygame.display.update()
            time.sleep(0.7)
            l += 1



        elif len(bf) == 0 or l == len(bf):
            screen.fill((0, 255, 0), rect=[200, 550, 20, 30])
            for i in range(0, 4):
                for j in range(0, 4):
                    if (sudoku.board_easy[i][j] != 0):
                        show_text2(str(sudoku.board_easy[i][j]), 70 + 50 * j, 60 + 50 * i)
    if medium:
        # show_text("medium", 350, 200)

        for i in range(0, 7):
            if i == 0 or i == 6:
                pygame.draw.line(screen, (181, 59, 20), (50 + 50 * i, 50), (50 + 50 * i, 350), 5)
                pygame.draw.line(screen, (181, 59, 20), (50, 50 + 50 * i), (350, 50 + 50 * i), 5)
            elif i % 3 == 0:
                pygame.draw.line(screen, (181, 59, 20), (50 + 50 * i, 50), (50 + 50 * i, 350), 5)
                pygame.draw.line(screen, (181, 59, 20), (50, 50 + 50 * i), (350, 50 + 50 * i), 2)
            elif i % 2 == 0:
                pygame.draw.line(screen, (181, 59, 20), (50 + 50 * i, 50), (50 + 50 * i, 350), 2)
                pygame.draw.line(screen, (181, 59, 20), (50, 50 + 50 * i), (350, 50 + 50 * i), 5)
            else:
                pygame.draw.line(screen, (181, 59, 20), (50 + 50 * i, 50), (50 + 50 * i, 350), 2)
                pygame.draw.line(screen, (181, 59, 20), (50, 50 + 50 * i), (350, 50 + 50 * i), 2)
        if l < (len(bf)):
            for i in range(0, 6):
                for j in range(0, 6):
                    if bf[l][i][j] != 0:
                        if b2[i][j] == 0:
                            show_text3(str(bf[l][i][j]), 70 + 50 * j, 60 + 50 * i)
                        else:
                            show_text2(str(bf[l][i][j]), 70 + 50 * j, 60 + 50 * i)
            if l < len(bf) - 1:

                screen.fill((255, 0, 0), rect=[200, 550, 20, 30])
            else:
                screen.fill((252, 225, 0), rect=[200, 550, 20, 30])
            pygame.display.update()
            time.sleep(0.7)
            l += 1

        elif len(bf) == 0 or l == len(bf):
            screen.fill((0, 255, 0), rect=[200, 550, 20, 30])
            for i in range(0, 6):
                for j in range(0, 6):
                    if (sudoku.board_medium[i][j] != 0):
                        show_text2(str(sudoku.board_medium[i][j]), 70 + 50 * j, 60 + 50 * i)

    if hard:

        # show_text("hard", 350, 200)
        for i in range(0, 10):
            if (i % 3 == 0):
                pygame.draw.line(screen, (181, 59, 20), (50 + 50 * i, 50), (50 + 50 * i, 500), 5)
                pygame.draw.line(screen, (181, 59, 20), (50, 50 + 50 * i), (500, 50 + 50 * i), 5)
            else:
                pygame.draw.line(screen, (181, 59, 20), (50 + 50 * i, 50), (50 + 50 * i, 500), 2)
                pygame.draw.line(screen, (181, 59, 20), (50, 50 + 50 * i), (500, 50 + 50 * i), 2)
        if l < (len(bf)):
            for i in range(0, 9):
                for j in range(0, 9):
                    if bf[l][i][j] != 0:
                        if b3[i][j] == 0:
                            show_text3(str(bf[l][i][j]), 70 + 50 * j, 60 + 50 * i)
                        else:
                            show_text2(str(bf[l][i][j]), 70 + 50 * j, 60 + 50 * i)
            if l < len(bf) - 1:

                screen.fill((255, 0, 0), rect=[200, 550, 20, 30])
            else:
                screen.fill((252, 225, 0), rect=[200, 550, 20, 30])
            pygame.display.update()
            time.sleep(0.7)
            l += 1

        elif len(bf) == 0 or l == len(bf):
            for i in range(0, 9):
                for j in range(0, 9):
                    if sudoku.board_hard[i][j] != 0:
                        show_text2(str(sudoku.board_hard[i][j]), 70 + 50 * j, 60 + 50 * i)
            screen.fill((0, 255, 0), rect=[200, 550, 20, 30])

    pygame.display.update()

pygame.quit()
