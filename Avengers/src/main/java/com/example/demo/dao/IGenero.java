package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Genero;

public interface IGenero extends JpaRepository<Genero, String>  {

}
