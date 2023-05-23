package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();

         // UMA MANEIRA DE TRABALHAR COM EXCEPTION NO JUNI
        // informa a exception que está esperando quando chamar o metodo
        // o 2 parametro não é a chama o metodo em sí, tem que colocar um parametro
        // do java 8 () ->
        //assertThrows(IllegalArgumentException.class,
         //       () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

        //OUTRA MANEIRA
        //faz um try catch. Se chegou no catch é pq deu certo, se chegar na linha apos a chamada do metedod é
        //pq falhou, ai tem que chamar o fail() do JUnit para forcar o metodo de teste falhar
        try {
            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
            fail("Nao deu a exception");
        } catch (Exception e) {
            //tem que cair aqui
            //verifica se está vindo com msg esperada
            assertEquals("Funcionario com salário maior que 10000 não pode receber o bonus", e.getMessage());
        }
    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }


}
