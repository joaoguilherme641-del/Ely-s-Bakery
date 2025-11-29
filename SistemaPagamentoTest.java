import org.junit.Test;
import org.junit.Assert;

public class SistemaPagamentoTest {

    SistemaPagamento sistema = new SistemaPagamento();

    // ==========================================
    // PARTE 1: Pagamento em Dinheiro (CT01 ao CT04)
    // ==========================================
    @Test
    public void teste1_Dinheiro() {
        System.out.println("\n--- TABELA 1: DINHEIRO ---");
        
        Object[][] tabela = {
            {"CT01", 20.00,  20.00,  "Dinheiro", "Sem troco"},
            {"CT02", 10.00,  20.00,  "Dinheiro", "Troco: 10.00"},
            {"CT03", 5.50,   10.00,  "Dinheiro", "Troco: 4.50"},
            {"CT04", 100.00, 150.00, "Dinheiro", "Troco: 50.00"}
        };

        executar(tabela);
    }

    // ==========================================
    // PARTE 2: Pagamento Eletrônico (CT05 ao CT07)
    // ==========================================
    @Test
    public void teste2_Eletronico() {
        System.out.println("\n--- TABELA 2: ELETRONICOS ---");
        
        Object[][] tabela = {
            {"CT05", 50.00,  50.00,  "Cartao",   "Transacao Aprovada"},
            {"CT06", 30.00,  30.00,  "Pix",      "Comprovante enviado"},
            {"CT07", 20.00,  20.00,  "PIX",      "Comprovante enviado"}
        };

        executar(tabela);
    }

    // ==========================================
    // PARTE 3: Erros e Exceções (CT08 ao CT10)
    // ==========================================
    @Test
    public void teste3_Erros() {
        System.out.println("\n--- TABELA 3: ERROS ---");
        
        Object[][] tabela = {
            {"CT08", 50.00,  40.00,  "Dinheiro", "Erro: Valor insuficiente"},
            {"CT09", 10.00,  10.00,  "Cheque",   "Metodo invalido"},
            {"CT10", 10.00,  0.00,   "Dinheiro", "Erro: Valor insuficiente"}
        };

        executar(tabela);
    }

    // Método auxiliar para rodar a lógica (evita repetir código)
    private void executar(Object[][] tabela) {
        for (Object[] linha : tabela) {
            String id = (String) linha[0];
            double pedido = (double) linha[1];
            double pago = (double) linha[2];
            String metodo = (String) linha[3];
            String esperado = (String) linha[4];

            String resultado = sistema.processarPagamento(pedido, pago, metodo);

            Assert.assertEquals("Falha no " + id, esperado, resultado);
            System.out.println("PASSOU: " + id + " | " + esperado);
        }
    }
}