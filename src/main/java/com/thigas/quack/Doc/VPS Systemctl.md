# Documentação de Atualização e Reinicialização do Serviço `quack`

Este documento explica o processo para atualizar o JAR da aplicação `quack` e reiniciar o serviço no Ubuntu utilizando o
`systemd`.

## Pré-requisitos

- A aplicação `quack` deve estar configurada como um serviço `systemd`.
- O novo arquivo JAR deve estar no mesmo caminho que o JAR antigo (por exemplo, `/opt/quack/quack.jar`).

---

## Passos para Atualizar e Reiniciar o Serviço

### 1. Substituir o JAR Antigo pelo Novo

Se o novo JAR foi baixado para o mesmo caminho do antigo, não é necessário mover ou copiar o arquivo. Certifique-se de
que ele está no local correto.

### 2. Reiniciar o Serviço `quack`

Reinicie o serviço para que ele utilize o novo JAR:

```bash
sudo systemctl restart quack
3. Verificar o Status do Serviço
Após reiniciar o serviço, verifique se ele está em execução e sem erros:

bash
Copiar código
sudo systemctl status quack
Você deverá ver uma saída indicando que o serviço está active (running), o que significa que o serviço quack está rodando corretamente.

4. Monitorar os Logs (Opcional)
Para confirmar que o novo JAR está funcionando conforme esperado, observe os logs do serviço em tempo real:

bash
Copiar código
journalctl -u quack -f
Este comando exibe as mensagens de log geradas pela aplicação quack. Ele ajuda a identificar eventuais erros de inicialização ou mensagens importantes da aplicação.

Exemplo de Arquivo de Configuração do Serviço
O arquivo de configuração do systemd para o serviço quack normalmente fica em /etc/systemd/system/quack.service. Abaixo está um exemplo básico do conteúdo deste arquivo:

ini
Copiar código
[Unit]
Description=Quack Application
After=network.target

[Service]
User=seu_usuario
ExecStart=/usr/bin/java -jar /opt/quack/quack.jar
Restart=always

[Install]
WantedBy=multi-user.target
Este arquivo define como o systemd deve iniciar a aplicação quack. Certifique-se de que o caminho do JAR está correto em ExecStart.

Comandos Úteis
Parar o serviço:

bash
Copiar código
sudo systemctl stop quack
Iniciar o serviço:

bash
Copiar código
sudo systemctl start quack
Reiniciar o serviço:

bash
Copiar código
sudo systemctl restart quack
Recarregar a configuração do systemd (necessário após alterações no arquivo .service):

bash
Copiar código
sudo systemctl daemon-reload
```
