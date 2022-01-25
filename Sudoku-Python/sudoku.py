from copy import deepcopy

import util
import copy
import time


board_easy=[
    [0,0,4,0],
    [1,0,0,2],
    [0,2,1,0],
    [0,0,0,3]
]
board_medium=[
    [0,0,1,2,0,0],
    [6,0,0,0,4,0],
    [0,5,0,0,3,0],
    [0,1,0,6,0,5],
    [4,0,5,0,1,6],
    [0,0,0,0,0,2]
]
board_hard=[
    [7,8,0,4,0,0,1,2,0],
    [6,0,0,0,7,5,0,0,9],
    [0,0,0,6,0,1,0,7,8],
    [0,0,7,0,4,0,2,6,0],
    [0,0,1,0,5,0,9,3,0],
    [9,0,4,0,6,0,0,0,5],
    [0,7,0,3,0,0,0,1,2],
    [1,2,0,0,0,7,4,0,0],
    [0,4,9,2,0,6,0,0,7]
]
board_easy_cost=[
    [0, 0, 1, 0],
    [1, 0, 0, 1],
    [0, 1, 1, 0],
    [0, 0, 0, 1]
]
board_medium_cost=[
    [0, 0, 1, 1, 0, 0],
    [1, 0, 0, 0, 1, 0],
    [0, 1, 0, 0, 1, 0],
    [0, 1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1, 1],
    [0, 0, 0, 0, 0, 1]
]
board_hard_cost=[
    [1, 1, 0, 1, 0, 0, 1, 1, 0],
    [1, 0, 0, 0, 1, 1, 0, 0, 1],
    [0, 0, 0, 1, 0, 1, 0, 1, 1],
    [0, 0, 1, 0, 1, 0, 1, 1, 0],
    [0, 0, 1, 0, 1, 0, 1, 1, 0],
    [1, 0, 1, 0, 1, 0, 0, 0, 1],
    [0, 1, 0, 1, 0, 0, 0, 1, 1],
    [1, 1, 0, 0, 0, 1, 1, 0, 0],
    [0, 1, 1, 1, 0, 1, 0, 0, 1]
]
board_frames=[]

def find_empty(bo):
    for i in range(len(bo)):
        for j in range(len(bo[0])):
            if bo[i][j] == 0:
                return (i, j)  # row, col

    return None

def solve(bo,niv):
    find = find_empty(bo)
    if not find:
        return True
    else:
        row, col = find

    for i in range(1,10):
        if valid(bo, i, (row, col),niv):
            bo[row][col] = i
            board_frames.append(bo)
            if solve(bo,niv):
                return True

            bo[row][col] = 0

    return False


def valid(bo, num, pos,niv):
    # Check row
    for i in range(len(bo[0])):
        if bo[pos[0]][i] == num and pos[1] != i:
            return False

    # Check column
    for i in range(len(bo)):
        if bo[i][pos[1]] == num and pos[0] != i:
            return False

    # Check box
    if(niv==1):
        box_x = pos[1] // 2
        box_y = pos[0] // 2

        for i in range(box_y*2, box_y*2 + 2):
            for j in range(box_x * 2, box_x*2 + 2):
                if bo[i][j] == num and (i,j) != pos:
                    return False

        return True
    if (niv == 2):
        box_x = pos[1] // 3
        box_y = pos[0] // 2

        for i in range(box_y * 2, box_y * 2 + 2):
            for j in range(box_x * 3, box_x * 3 + 3):
                if bo[i][j] == num and (i, j) != pos:
                    return False

        return True
    if (niv == 3):
        box_x = pos[1] // 3
        box_y = pos[0] // 3

        for i in range(box_y * 3, box_y * 3 + 3):
            for j in range(box_x * 3, box_x * 3 + 3):
                if bo[i][j] == num and (i, j) != pos:
                    return False

        return True

def isGoalState(bo):
    for i in range(len(bo)):
        for j in range(len(bo[0])):
            if bo[i][j] == 0:
                return False
    return True


def firstempty(bo):
    for i in range(len(bo)):
        for j in range(len(bo[0])):
            if bo[i][j] == 0:
                return (i,j)
    return []

def DFS(bo,niv):
   start=bo
   explored=[]
   #explored.append(start)
   states=util.Stack()
   states.push(start)
   while not states.isEmpty():
       currentB=states.pop()
       board_frames.append(copy.deepcopy(currentB))
       #print(currentB)
       if isGoalState(currentB):
           return currentB
       fe=firstempty(currentB)

       if niv == 1:
           for ni in range(1, 5):
               if valid(currentB, ni, (fe[0],fe[1]), niv):
                   aux = copy.deepcopy(currentB)
                   aux[fe[0]][fe[1]] = ni
                   # if not (fe, ni) in explored:
                   explored.append((fe, ni))
                   states.push(aux)
           #print(explored)
       elif niv == 2:
           for ni in range(1, 7):
               if valid(currentB, ni, (fe[0], fe[1]), niv):
                   aux = copy.deepcopy(currentB)
                   aux[fe[0]][fe[1]] = ni
                   # if not (fe, ni) in explored:
                   explored.append((fe, ni))
                   states.push(aux)

       elif niv == 3:
           for ni in range(1, 10):
               if valid(currentB, ni, (fe[0], fe[1]), niv):
                   aux = copy.deepcopy(currentB)
                   aux[fe[0]][fe[1]] = ni
                   #if not (fe, ni) in explored:
                   explored.append((fe, ni))
                   states.push(aux)

   return []
def BFS(bo,niv):
   start=bo
   explored=[]
   #explored.append(start)
   states=util.Queue()
   states.push(start)
   while not states.isEmpty():
       currentB=states.pop()
       board_frames.append(copy.deepcopy(currentB))
       if isGoalState(currentB):
           return currentB
       fe=firstempty(currentB)
       if niv == 1:
           for ni in range(1, 5):
               if valid(currentB, ni, (fe[0],fe[1]), niv):
                   aux = copy.deepcopy(currentB)
                   aux[fe[0]][fe[1]] = ni
                   # if not (fe, ni) in explored:
                   explored.append((fe, ni))
                   states.push(aux)
           #print(explored)
       elif niv == 2:
           for ni in range(1, 7):
               if valid(currentB, ni, (fe[0], fe[1]), niv):
                   aux = copy.deepcopy(currentB)
                   aux[fe[0]][fe[1]] = ni
                   # if not (fe, ni) in explored:
                   explored.append((fe, ni))
                   states.push(aux)

       elif niv == 3:
           for ni in range(1, 10):
               if valid(currentB, ni, (fe[0], fe[1]), niv):
                   aux = copy.deepcopy(currentB)
                   aux[fe[0]][fe[1]] = ni
                   #if not (fe, ni) in explored:
                   explored.append((fe, ni))
                   states.push(aux)

   return []
def getCostOfActions(self):
        """
         actions: A list of actions to take
        This method returns the total cost of a particular sequence of actions.  The sequence must
        be composed of legal moves
        """
        return self
def UniformSearch(bo,niv):
    start = bo
    newcost=0
    explored = []
    # explored.append(start)
    states = util.PriorityQueue()
    states.push((start,0),0)
    while not states.isEmpty():
        currentS= states.pop()
        #print(start)
        currentB=currentS[0]
        #print(currentB)
        cost=currentS[1]
        board_frames.append(copy.deepcopy(currentB))
        if isGoalState(currentB):
            return (currentB,cost)
        fe = firstempty(currentB)
        if niv == 1:
            for ni in range(1, 5):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    explored.append((fe, ni))
                    newcost=cost+1
                    states.push((aux,newcost),getCostOfActions(newcost))
            # print(explored)
        elif niv == 2:
            for ni in range(1, 7):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    explored.append((fe, ni))
                    newcost = cost + 1
                    states.push((aux,newcost),getCostOfActions(newcost))

        elif niv == 3:
            for ni in range(1, 10):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    explored.append((fe, ni))
                    newcost = cost + 1
                    states.push((aux,newcost),getCostOfActions(newcost))

    return []
def nullHeuristic(state):
    """
    A heuristic function estimates the cost from the current state to the nearest
    goal in the provided SearchProblem.  This heuristic is trivial.
    """
    return 0

def AS(bo,niv):
    start = bo
    newcost=0
    explored = []
    # explored.append(start)
    states = util.PriorityQueue()
    states.push((start,0),nullHeuristic(start))
    nCost=0
    while not states.isEmpty():
        currentS= states.pop()
        #print(start)
        currentB=currentS[0]
        #print(currentB)
        cost=currentS[1]
        board_frames.append(copy.deepcopy(currentB))
        if isGoalState(currentB):
            return (currentB,cost)
        fe = firstempty(currentB)
        if niv == 1:
            for ni in range(1, 5):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    explored.append((fe, ni))
                    newcost=cost+1
                    nCost=getCostOfActions(newcost)+nullHeuristic(currentB)
                    states.push((aux,newcost),nCost)
            # print(explored)
        elif niv == 2:
            for ni in range(1, 7):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    explored.append((fe, ni))
                    newcost = cost + 1
                    nCost = getCostOfActions(newcost) + nullHeuristic(currentB)
                    states.push((aux, newcost), nCost)

        elif niv == 3:
            for ni in range(1, 10):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    explored.append((fe, ni))
                    newcost = cost + 1
                    nCost = getCostOfActions(newcost) + nullHeuristic(currentB)
                    states.push((aux, newcost), nCost)

    return []
def Heuristic2(bo):
    zeros=0
    for i in range (len (bo)):
        for j in range (len(bo[0])):
            if bo[i][j]==0:
                zeros+=1
    return zeros

def AS2(bo,niv):
    start = bo
    newcost=0
    explored = []
    # explored.append(start)
    states = util.PriorityQueue()
    states.push((start,0),Heuristic2(start))
    nCost=0
    while not states.isEmpty():
        currentS= states.pop()
        #print(start)
        currentB=currentS[0]
        #print(currentB)
        cost=currentS[1]
        board_frames.append(copy.deepcopy(currentB))
        if isGoalState(currentB):
            return (currentB,cost)
        fe = firstempty(currentB)
        if niv == 1:
            for ni in range(1, 5):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    board_easy_cost[fe[0]][fe[1]]+=1
                    explored.append((fe, ni))
                    newcost=cost+1
                    nCost=getCostOfActions(newcost)+Heuristic2(board_easy_cost)
                    states.push((aux,nCost),nCost)
            # print(explored)
        elif niv == 2:
            for ni in range(1, 7):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    board_medium_cost[fe[0]][fe[1]] += 1
                    explored.append((fe, ni))
                    newcost = cost + 1
                    nCost = getCostOfActions(newcost) + Heuristic2(board_medium_cost)
                    states.push((aux, nCost), nCost)

        elif niv == 3:
            for ni in range(1, 10):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    board_hard_cost[fe[0]][fe[1]] += 1
                    explored.append((fe, ni))
                    newcost = cost + 1
                    nCost = getCostOfActions(newcost) + Heuristic2(board_hard_cost)
                    states.push((aux, nCost), nCost)

    return []
def Heuristic3(bo,niv):
    count=0
    if niv==1:
        found=0
        combinatii=[[0,0],[0,1],[1,0],[1,0]]
        for s in range (len(combinatii)):
            si = combinatii[s][0]
            sj = combinatii[s][1]
            for i in range (0,2):
                for j in range(0,2):
                    if bo[2*si+i][2*sj+j]==0:
                        found=1
        if found==1:
            count+=1
    elif niv==2:
        found=0
        combinatii=[[0,0],[0,1],[0,2],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2]]
        for s in range (len(combinatii)):
            si = combinatii[s][0]
            sj = combinatii[s][1]
            for i in range (0,2):
                for j in range(0,3):
                    if bo[2*si+i][3*sj+j]==0:
                        found=1
        if found==1:
            count+=1
    elif niv==3:
        found=0
        combinatii=[[0,0],[0,1],[0,2],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2]]
        for s in range (len(combinatii)):
            si = combinatii[s][0]
            sj = combinatii[s][1]
            for i in range (0,3):
                for j in range(0,3):
                    if bo[si+i][sj+j]==0:
                        found=1
        if found==1:
            count+=1
    return found
def AS3(bo,niv):
    start = bo
    newcost=0
    explored = []
    # explored.append(start)
    states = util.PriorityQueue()
    states.push((start,0),Heuristic3(start))
    nCost=0
    while not states.isEmpty():
        currentS= states.pop()
        #print(start)
        currentB=currentS[0]
        #print(currentB)
        cost=currentS[1]
        board_frames.append(copy.deepcopy(currentB))
        if isGoalState(currentB):
            return (currentB,cost)
        fe = firstempty(currentB)
        if niv == 1:
            for ni in range(1, 5):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    board_easy_cost[fe[0]][fe[1]]+=1
                    explored.append((fe, ni))
                    newcost=cost+1
                    nCost=getCostOfActions(newcost)+Heuristic3(board_easy_cost,niv)
                    states.push((aux,nCost),nCost)
            # print(explored)
        elif niv == 2:
            for ni in range(1, 7):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    board_medium_cost[fe[0]][fe[1]] += 1
                    explored.append((fe, ni))
                    newcost = cost + 1
                    nCost = getCostOfActions(newcost) + Heuristic3(board_medium_cost,niv)
                    states.push((aux, nCost), nCost)

        elif niv == 3:
            for ni in range(1, 10):
                if valid(currentB, ni, (fe[0], fe[1]), niv):
                    aux = copy.deepcopy(currentB)
                    aux[fe[0]][fe[1]] = ni
                    # if not (fe, ni) in explored:
                    board_hard_cost[fe[0]][fe[1]] += 1
                    explored.append((fe, ni))
                    newcost = cost + 1
                    nCost = getCostOfActions(newcost) + Heuristic3(board_hard_cost, niv)
                    states.push((aux, nCost), nCost)

    return []

def refreshCostMatrix():
    board_easy_cost = [
        [0, 0, 1, 0],
        [1, 0, 0, 1],
        [0, 1, 1, 0],
        [0, 0, 0, 1]
    ]
    board_medium_cost = [
        [0, 0, 1, 1, 0, 0],
        [1, 0, 0, 0, 1, 0],
        [0, 1, 0, 0, 1, 0],
        [0, 1, 0, 1, 0, 1],
        [1, 0, 1, 0, 1, 1],
        [0, 0, 0, 0, 0, 1]
    ]
    board_hard_cost = [
        [1, 1, 0, 1, 0, 0, 1, 1, 0],
        [1, 0, 0, 0, 1, 1, 0, 0, 1],
        [0, 0, 0, 1, 0, 1, 0, 1, 1],
        [0, 0, 1, 0, 1, 0, 1, 1, 0],
        [0, 0, 1, 0, 1, 0, 1, 1, 0],
        [1, 0, 1, 0, 1, 0, 0, 0, 1],
        [0, 1, 0, 1, 0, 0, 0, 1, 1],
        [1, 1, 0, 0, 0, 1, 1, 0, 0],
        [0, 1, 1, 1, 0, 1, 0, 0, 1]
    ]