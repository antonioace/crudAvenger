package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Clasificacion;

public interface IClasificacion extends JpaRepository<Clasificacion, String>  {

}
