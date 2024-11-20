package com.thigas.quack.UseCase.Presenter;

import com.thigas.quack.UseCase.Model.Response.ResultDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.User.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.User.UserRegisterDtoResponseModel;

/**
 * Interface responsável por preparar as visualizações de resposta para operações relacionadas ao usuário.
 *
 * <p>Esta interface define métodos para preparar as respostas de sucesso e falha
 * para operações de login e registro de usuários.</p>
 */
public interface UserPresenter {

    /**
     * Prepara a visualização de sucesso para a operação de login.
     *
     * @param user o modelo de resposta contendo as informações do usuário logado.
     * @return o modelo de resposta preparado para a visualização de sucesso.
     */
    UserLoginDtoResponseModel prepareLoginSuccessView(UserLoginDtoResponseModel user);

    /**
     * Prepara a visualização de falha para a operação de login.
     *
     * @param error o modelo de resposta contendo as informações de erro.
     * @return o modelo de resposta preparado para a visualização de falha.
     */
    UserLoginDtoResponseModel prepareLoginFailView(ResultDtoResponseModel error);

    /**
     * Prepara a visualização de sucesso para a operação de registro.
     *
     * @param user o modelo de resposta contendo as informações do usuário registrado.
     * @return o modelo de resposta preparado para a visualização de sucesso.
     */
    UserRegisterDtoResponseModel prepareRegisterSuccessView(UserRegisterDtoResponseModel user);

    /**
     * Prepara a visualização de falha para a operação de registro.
     *
     * @param error o modelo de resposta contendo as informações de erro.
     * @return o modelo de resposta preparado para a visualização de falha.
     */
    UserRegisterDtoResponseModel prepareRegisterFailView(ResultDtoResponseModel error);
}