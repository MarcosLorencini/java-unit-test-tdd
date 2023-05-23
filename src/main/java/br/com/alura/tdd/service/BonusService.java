package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));

		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw  new IllegalArgumentException("Funcionario com salário maior que " +
					"10000 não pode receber o bonus");

			//Se não tiver bonus é erro, o sistema não pode permitir
		}

		return valor.setScale(2, RoundingMode.HALF_UP); //arredonda para cima se for numero quebrado
	}

}
