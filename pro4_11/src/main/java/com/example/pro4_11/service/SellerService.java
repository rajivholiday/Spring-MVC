package com.example.pro4_11.service;

import com.example.pro4_11.entity.Seller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SellerService implements DAO<Seller>{
    private final ArrayList<Seller> sellers = new ArrayList<>();

    @Override
    public void create(Seller seller) {
        sellers.add(seller);
    }

    @Override
    public List<Seller> getAll() {
        return sellers;
    }
    @Override
    public Optional<Seller> get(int id) {
        for (Seller s : sellers)
            if (s.getId() == id) {
                return Optional.of(s);
            }
        return Optional.empty();
    }
    @Override
    public void update(int id, Seller seller) {
        for (Seller s : sellers)
            if (s.getId() == id) {
                s.setId(seller.getId());
                s.setCompanyName(seller.getCompanyName());
            }
    }
    @Override
    public void delete(int id) {
        for (Seller s : sellers)
            if (s.getId() == id) {
                sellers.remove(s);
                break;
            }
    }

}
