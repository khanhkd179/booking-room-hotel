/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ClientDAO;
import model.Client;

/**
 *
 * @author Monkay
 */
public class ClientService {
    public Client searchClient(String tel){
        ClientDAO clientDao=new ClientDAO();
        return clientDao.searchClient(tel);
    }
    public Client addClient(Client client){
        ClientDAO clientDao=new ClientDAO();
        return clientDao.addClient(client);
    }
    
}
