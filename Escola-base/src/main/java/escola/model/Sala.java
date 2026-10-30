package escola.model;

import ;
import ;



private String nome;

private Integer capacidade;

private boolean reservada = false;

public Sala() {}

public Long getId() { return id; }
public String getCodigo() { return codigo; }
public String getNome() { return nome; }
public Integer getCapacidade() { return capacidade; }
public boolean isReservada() { return reservada; }

public void setCodigo(String c) { codigo = c; }
public void setNome(String n) { nome = n; }
public void setCapacidade(Integer c) { capacidade = c; }
public void setReservada(boolean r) { reservada = r; }
}