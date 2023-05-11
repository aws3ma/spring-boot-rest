package com.idsd.produits.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.idsd.produits.entities.Produit;
import com.idsd.produits.service.ProduitService;

@Controller
public class ProduitController {
	@Autowired
	private ProduitService produitService;


	@GetMapping("/showCreate")
	public String showCreate() {
		return "createProduit"; // le nom de la jsp
	}

	@PostMapping("/saveProduit") // l’action
	public String saveProduit(@ModelAttribute("produit") Produit produit, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		produit.setDateProduit(dateCreation);
		Produit saveProduit = produitService.saveProduit(produit);
		// enregister le produit dans la base de donnée
		String msg = "produit enregistré avec Id " + saveProduit.getIdProduit();
		modelMap.addAttribute("msg", msg);
		return "createProduit";
	}

	@GetMapping("/ListeProduits")
	public String listeProduits(ModelMap modelMap) {
		List<Produit> prods = produitService.getAllProduits();
		modelMap.addAttribute("produits", prods);
		return "listeProduits";
	}

}
