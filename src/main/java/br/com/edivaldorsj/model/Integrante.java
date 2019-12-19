package br.com.edivaldorsj.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Integrante {

  private Long id;
  private String nome;
  private String apelido;
  private Character sexo;

}
