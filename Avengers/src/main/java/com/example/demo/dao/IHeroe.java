package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Heroe;

public interface IHeroe extends JpaRepository<Heroe, Integer>  {

}
