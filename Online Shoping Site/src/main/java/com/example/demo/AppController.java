package com.example.demo;


import com.example.demo.comenzi.Comanda;
import com.example.demo.comenzi.ComandaFromDatabase;
import com.example.demo.cos.CosFromDatabase;
import com.example.demo.cos.ProdusCos;
import com.example.demo.produse.Produs;
import com.example.demo.produse.ProdusFromDatabase;
import com.example.demo.user.User;
import com.example.demo.user.UserModifyInDataBase;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
    public class AppController {

        @Autowired
        private UserRepository userRepo;


        @GetMapping("")
        public String viewHomePage(Model model) throws SQLException {
            ProdusFromDatabase pr=new ProdusFromDatabase();
            List<Produs> p1=pr.vizualizareProduse();
            Produs prod=new Produs();

            model.addAttribute("produse",p1);
            model.addAttribute("inp",prod);
            return "home";
        }

    @GetMapping("/admin")
    public String listUsers(Model model) throws SQLException {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        ProdusFromDatabase p=new ProdusFromDatabase();
        List<Produs> listProd=p.vizualizareProduse();
        model.addAttribute("listProd",listProd);

        ComandaFromDatabase c=new ComandaFromDatabase();
        List<Comanda> listCo=c.vizualizareComenzi();
        model.addAttribute("listCo",listCo);

        return "administrator";
    }

    @GetMapping("/home")
    public String goHomeL(Model model) throws SQLException {
        ProdusFromDatabase pr=new ProdusFromDatabase();
        List<Produs> p1=pr.vizualizareProduse();
        model.addAttribute("produse",p1);
        model.addAttribute("user",new User());
        Produs prod=new Produs();
        model.addAttribute("inp",prod);
        return "home2";
    }

        @GetMapping("/Register")
        public String Register(Model model){
            model.addAttribute("user", new User());
            return "register";}
        @PostMapping("/homeR")
        public String goHomeR(Model model,User user) throws SQLException {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            user.setRole("ROLE_CLIENT");
            userRepo.save(user);
            ProdusFromDatabase pr=new ProdusFromDatabase();
            List<Produs> p1=pr.vizualizareProduse();
            Produs prod=new Produs();

            model.addAttribute("produse",p1);
            model.addAttribute("inp",prod);
            return "home";
        }
    @RequestMapping("/client/{id}")
    public  ModelAndView showUser(@PathVariable(name = "id") Long id) throws SQLException {
        ModelAndView mav = new ModelAndView("client");
        User user = userRepo.findByID(id);
        ComandaFromDatabase c=new ComandaFromDatabase();
        List<Comanda> comenzi=c.vizualizareComenziClient(user.getEmail());
        mav.addObject("user", user);
        mav.addObject("listCo",comenzi);
        return mav;
    }
    @Transactional
    @PostMapping( "/saveu")
    public String saveUser(@ModelAttribute("user") User user,Model model) throws SQLException {
     //  UserModifyInDataBase um=new UserModifyInDataBase();
       // um.updateUser(user);
        userRepo.updateUser(user.getLastName(),user.getFirstName(),user.getRole(), user.getEmail());
        ProdusFromDatabase pr=new ProdusFromDatabase();
        List<Produs> p1=pr.vizualizareProduse();
        Produs prod=new Produs();

        model.addAttribute("produse",p1);
        model.addAttribute("inp",prod);
        return "home2";
    }
    @Transactional
    @RequestMapping("/delete/{email}")
    public String deleteUser(@PathVariable(name = "email") String email)  throws SQLException {
        //  UserModifyInDataBase um=new UserModifyInDataBase();
        // um.updateUser(user);
        //System.out.println(email);
        userRepo.deleteUser(email);
        return "deleted2";
    }
    @GetMapping("/provider")
    public String goToProvider(Model model){
            model.addAttribute("produs", new Produs());
            return "providerPage";
    }
    @PostMapping("/homeFromProvider")
    public String goHomeP(Produs produs, Model model) throws SQLException {
            ProdusFromDatabase p=new ProdusFromDatabase();
            if(p.verificareExistentaProdus(produs)==true){
                int cant=p.cantitateProdus(produs);
                int cant2= produs.getQuantity();
                produs.setQuantity(cant+cant2);
                p.updateProdus(produs);
            }
            else{
                p.insertProdus(produs);
            }
        ProdusFromDatabase pr=new ProdusFromDatabase();
        List<Produs> p1=pr.vizualizareProduse();
        Produs prod=new Produs();

        model.addAttribute("produse",p1);
        model.addAttribute("inp",prod);
            return "home2";
    }
    @GetMapping("/newUser")
    public String createNewUser(Model model){
            model.addAttribute("user",new User());
            return "newClient";
    }
    @PostMapping("/saveNewUser")
    public String saveNewUSer(User user, Model model) throws SQLException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        ProdusFromDatabase pr=new ProdusFromDatabase();
        List<Produs> p1=pr.vizualizareProduse();
        Produs prod=new Produs();

        model.addAttribute("produse",p1);
        model.addAttribute("inp",prod);
        return "home2";
    }
    @RequestMapping("/myAccount/{email}")
    public  ModelAndView showMyUser(@PathVariable(name = "email") String email) throws SQLException {
        ModelAndView mav = new ModelAndView("myAccount");
        User user = userRepo.findByEmail(email);
        ComandaFromDatabase c=new ComandaFromDatabase();
        List<Comanda> comenzi=c.vizualizareComenziClient(user.getEmail());
        mav.addObject("user", user);
        mav.addObject("listCo",comenzi);
        return mav;
    }
    @Transactional
    @PostMapping( "/savemy")
    public String saveMyUser(@ModelAttribute("user") User user,Model model) throws SQLException {
        //  UserModifyInDataBase um=new UserModifyInDataBase();
        // um.updateUser(user);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        userRepo.updateUserPass(user.getLastName(),user.getFirstName(),user.getRole(),encodedPassword,user.getAddress(), user.getEmail());
        ProdusFromDatabase pr=new ProdusFromDatabase();
        List<Produs> p1=pr.vizualizareProduse();
        Produs prod=new Produs();

        model.addAttribute("produse",p1);
        model.addAttribute("inp",prod);
        return "home2";
    }
    @Transactional
    @RequestMapping("/deletemy/{email}")
    public String deleteMyUser(@PathVariable(name = "email") String email)  throws SQLException {
        //  UserModifyInDataBase um=new UserModifyInDataBase();
        // um.updateUser(user);
        //System.out.println(email);
        userRepo.deleteUser(email);
        return "deleted";
    }
    @GetMapping("/deleted")
    public String deleted(){
            return "deleted";
    }
    @GetMapping("/produs")
    public String goProdus(Model model){
            Produs p=new Produs();
            p.setName("merge");
            p.setImage1("p2.jpg");
            p.setImage2("p3.jpg");
            p.setImage3("p4.jpg");
            model.addAttribute("produs",p);

            return "Produs";
    }

    @RequestMapping("/produs/{id}")
    public  ModelAndView showProdus(@PathVariable(name = "id") Long id) throws SQLException {
        ModelAndView mav = new ModelAndView("Produs");
        ProdusFromDatabase pr=new ProdusFromDatabase();
        Produs p=pr.vizualizareProdus(id);
        mav.addObject("produs", p);
        return mav;
    }
    @Transactional
    @RequestMapping("/adaugareP/{email}/{idp}")
    public String adaugarePr( @PathVariable(name = "email") String email,@PathVariable(name = "idp")Long idp,Model model) throws SQLException {
        //adaugare in lista de cumparaturi

        ProdusFromDatabase pr=new ProdusFromDatabase();
        System.out.println("s-a adaugat");
        CosFromDatabase cos=new CosFromDatabase();
        Produs produs=pr.vizualizareProdus(idp);
        ProdusCos prodc=new ProdusCos();
        prodc.setQuantityStock(produs.getQuantity());
        prodc.setCategory(produs.getCategory());
        prodc.setPrice(produs.getPrice());
        prodc.setName(produs.getName());
        prodc.setImage(produs.getImage1());
        prodc.setEmail(email);
        prodc.setQuantityCart(1);
        cos.insertProdusCos(prodc);
        List<Produs> p1=pr.vizualizareProduse();
        Produs prod=new Produs();

        model.addAttribute("produse",p1);
        model.addAttribute("inp",prod);
        return "home3";
    }

    @RequestMapping("/ShoppingCart/{email}")
    public  ModelAndView showCart(@PathVariable(name = "email") String email) throws SQLException {
        ModelAndView mav = new ModelAndView("shopping_cart");
        CosFromDatabase cos=new CosFromDatabase();
        List<ProdusCos> pc=cos.vizualizareCos(email);
        mav.addObject("cos", pc);
        int total=cos.TotalV(email);

        mav.addObject("total",total);
        return mav;
    }
    @RequestMapping("/ShoppingCart2/{email}/{prod}")
    public  ModelAndView showCart2(@PathVariable(name = "email") String email,@PathVariable(name = "prod")String prc) throws SQLException {
        ModelAndView mav = new ModelAndView("shopping_cart");
        CosFromDatabase cos=new CosFromDatabase();
        ProdusCos proc=cos.vizualizareProdus(prc);
        proc.setEmail(email);
        if(proc.getName()!=null){
             cos.insertProdusCos(proc);
        }
        List<ProdusCos> pc=cos.vizualizareCos(email);
        mav.addObject("cos", pc);
        int total=cos.TotalV(email);

        mav.addObject("total",total);
        return mav;
    }
    @RequestMapping("/ShoppingCart3/{email}/{prod}")
    public  ModelAndView showCart3(@PathVariable(name = "email") String email,@PathVariable(name = "prod")String prc) throws SQLException {
        ModelAndView mav = new ModelAndView("shopping_cart");
        CosFromDatabase cos=new CosFromDatabase();
        ProdusCos proc=cos.vizualizareProdus(prc);
        proc.setEmail(email);
        if(proc.getName()!=null) {
            cos.deleteProdusCos(proc);
        }
        List<ProdusCos> pc=cos.vizualizareCos(email);
        mav.addObject("cos", pc);
        int total=cos.TotalV(email);

        mav.addObject("total",total);
        return mav;
    }

    @RequestMapping("/Order/{email}")
    public  ModelAndView showOrder(@PathVariable(name = "email") String email) throws SQLException {
        ModelAndView mav = new ModelAndView("plasareComanda");
        CosFromDatabase cd=new CosFromDatabase();
        Comanda co=new Comanda();
        co.setEmail(email);
        List<ProdusCos> pc=cd.vizualizareCos(email);
        co.setTotalValue(cd.TotalV(email));
        ProdusFromDatabase pd=new ProdusFromDatabase();
        for(ProdusCos p:pc) {
            Produs acP=pd.vizualizareProdusDupaNume(p.getName());
            int cant=acP.getQuantity()-p.getQuantityCart();
            acP.setQuantity(cant);
            pd.updateProdus(acP);
        }
        mav.addObject("comanda", co);
        return mav;
    }
    @PostMapping("/cautare1")
    public  String showByCategory(Model model, Produs prod) throws SQLException {

        ProdusFromDatabase p=new ProdusFromDatabase();
        List<Produs> listaprod=p.vizualizareProdusCat(prod.getCategory());
        model.addAttribute("produse", listaprod);
        model.addAttribute("inp",prod);
       return "home4";
    }
    @PostMapping("/cautare2")
    public  String showByName(Model model, Produs prod) throws SQLException {
        ProdusFromDatabase p=new ProdusFromDatabase();
        List<Produs> listaprod=p.vizualizareProdusNume(prod.getName());
        model.addAttribute("produse", listaprod);
        model.addAttribute("inp",prod);
        return "home4";

    }

    @PostMapping("/salvareComanda")
    public String salvareComanda(Comanda comanda,Model model) throws SQLException {
            ComandaFromDatabase co=new ComandaFromDatabase();
            co.insertcomanda(comanda);
            CosFromDatabase c=new CosFromDatabase();
            c.stergereProduse(comanda.getEmail());
        ProdusFromDatabase p=new ProdusFromDatabase();
        List<Produs> listaprod=p.vizualizareProduse();
        model.addAttribute("produse", listaprod);
        model.addAttribute("inp",new Produs());
            return "home2";
    }
}


