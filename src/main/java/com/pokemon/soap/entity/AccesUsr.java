package com.pokemon.soap.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

/**
 * Entidad donde se registran los datos.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "AccesUsr")
public class AccesUsr {
  /**
   * Id de la tabla AccesUser.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * TimeOn se guarda el día de la consulta.
   */
  private LocalDate timeOn;

  /**
   * CalledMethod donde se guarda el nombre del método qu se llama.
   */
  private String calledMethod;

  /**
   * Time se guarda en millisegundos el tiempo de la transacción.
   */
  private Long time;

  /**
   * Request guarda el valor de la petición.
   */
  private String request;

  /**
   * Response se almacena la respuesta del método.
   */
  private String response;

  /**
   * Ip donde se origina la petición.
   */
  private String ip;
}
