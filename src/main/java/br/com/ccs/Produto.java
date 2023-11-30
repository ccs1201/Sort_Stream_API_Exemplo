package br.com.ccs;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Produto {

    private String descricao;
    private Integer codigo;
}
