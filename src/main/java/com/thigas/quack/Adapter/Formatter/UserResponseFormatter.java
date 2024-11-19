package com.thigas.quack.Adapter.Formatter;

import com.thigas.quack.Domain.Utils.ResponseType;
import com.thigas.quack.UseCase.Model.Response.ResultDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserRegisterDtoResponseModel;
import com.thigas.quack.UseCase.Presenter.UserPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Implementação da interface {@link UserPresenter} que formata as respostas relacionadas
 * ao fluxo de autenticação e registro de usuários.
 *
 * <p>Essa classe lida com os dois tipos principais de respostas: sucesso e falha. Em casos
 * de sucesso, os dados de resposta são retornados formatados. Em casos de falha, uma
 * exceção {@link ResponseStatusException} é lançada para indicar o status HTTP e a mensagem
 * de erro correspondente.</p>
 *
 * <p>Essa implementação facilita a adaptação das respostas das camadas de aplicação para
 * as camadas externas, como controladores da API REST.</p>
 *
 * @see UserPresenter
 * @see UserLoginDtoResponseModel
 * @see UserRegisterDtoResponseModel
 * @see ResultDtoResponseModel
 */
public class UserResponseFormatter implements UserPresenter {

    /**
     * Prepara a resposta em caso de sucesso no login do usuário.
     *
     * <p>Essa implementação retorna uma nova instância de {@link UserLoginDtoResponseModel}
     * com os mesmos valores de ID e token fornecidos na resposta.</p>
     *
     * @param response O modelo de resposta contendo os dados de login do usuário.
     * @return Uma nova instância de {@link UserLoginDtoResponseModel}.
     */
    @Override
    public ResultDtoResponseModel prepareLoginSuccessView(ResultDtoResponseModel response) {
        return new ResultDtoResponseModel(response.message(), response.code(), response.responseType());
    }

    /**
     * Prepara a resposta em caso de falha no login do usuário.
     *
     * <p>Lança uma exceção {@link ResponseStatusException} com o código de erro HTTP e a mensagem
     * de erro especificados no modelo {@link ResultDtoResponseModel}.</p>
     *
     * @param error O modelo de erro contendo informações sobre o motivo da falha no login.
     * @throws ResponseStatusException Sempre que ocorre uma falha no login.
     */
    @Override
    public ResultDtoResponseModel prepareLoginFailView(ResultDtoResponseModel error) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error.message());
    }

    /**
     * Prepara a resposta em caso de sucesso no registro do usuário.
     *
     * <p>Essa implementação retorna uma nova instância de {@link UserRegisterDtoResponseModel}
     * contendo o e-mail, a senha e o token fornecidos na resposta.</p>
     *
     * @param response O modelo de resposta contendo os dados de registro do usuário.
     * @return Uma nova instância de {@link UserRegisterDtoResponseModel}.
     */
    @Override
    public ResultDtoResponseModel prepareRegisterSuccessView(ResultDtoResponseModel response) {
        return new ResultDtoResponseModel(response.message(), response.code(), response.responseType());
    }

    /**
     * Prepara a resposta em caso de falha no registro do usuário.
     *
     * <p>Lança uma exceção {@link ResponseStatusException} com o código de erro HTTP e a mensagem
     * de erro especificados no modelo {@link ResultDtoResponseModel}.</p>
     *
     * @param error O modelo de erro contendo informações sobre o motivo da falha no registro.
     * @throws ResponseStatusException Sempre que ocorre uma falha no registro.
     */
    @Override
    public ResultDtoResponseModel prepareRegisterFailView(ResultDtoResponseModel error) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error.message());
    }
}
