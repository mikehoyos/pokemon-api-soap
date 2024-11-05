package com.pokemon.soap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "AccesUsr")
public class AccesUsr {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate timeOn;
  private String calledMethod;
  private Long time;
  private String request;
  private String response;
  private String ip;
}
