package one.digitalinnovation.gof.facade;

import one.digitalinnovation.gof.facade.subsistema1.CrmService;
import one.digitalinnovation.gof.facade.subsistema2.CepApi;

public class Facade {

    private Facade() {
        super();
    }
    public static void migrarCliente(String nome, String cep) {
        String cidade = CepApi.getCepApi().recuperarCidade(cep);
        String estado = CepApi.getCepApi().recuperarEstado(cep);
        CrmService.gravarCliente(nome, cep, cidade, estado);
    }
}
