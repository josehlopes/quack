package com.thigas.quack.UseCase.Presenter;

import com.thigas.quack.UseCase.Util.ResponseWrapper;

public interface GenericPresenter {

    /**
     * Prepara a visualização de falha para a operação, encapsulando os dados de erro
     * em uma resposta com falha e o código HTTP apropriado, aceitando qualquer tipo de resposta.
     *
     * @param error o modelo de erro contendo as informações de falha.
     * @param <T> O tipo genérico de resposta, pode ser UserLoginResponseModel, UserRegisterResponseModel ou outros.
     * @return o modelo de resposta encapsulado em um {@link ResponseWrapper} com erro.
     */
    <T> ResponseWrapper<T> prepareFailView(T error, int statusCode);

    /**
     * Prepara a visualização de sucesso para a operação, encapsulando os dados de sucesso
     * em uma resposta com sucesso e o código HTTP apropriado, aceitando qualquer tipo de resposta.
     *
     * @param response o modelo de resposta contendo as informações de sucesso.
     * @param <T> O tipo genérico de resposta, pode ser UserLoginResponseModel, UserRegisterResponseModel ou outros.
     * @return o modelo de resposta encapsulado em um {@link ResponseWrapper} com sucesso.
     */
    <T> ResponseWrapper<T> prepareSuccessView(T response, int statusCode);
}
