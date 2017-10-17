# UFFMail

Para a compilação desse sistema foi utilizado:

    java version "1.8.0_144"
    Java(TM) SE Runtime Environment (build 1.8.0_144-b01)
    Java HotSpot(TM) 64-Bit Server VM (build 25.144-b01, mixed mode)

Rodando na IDE Eclipse (Oxygen - June 2017) sobre o sistema operacional Windows 10.

Para rodar o sistema, é necessário ter os arquivos ".java" que estão disponibilizados no GitHub, criar 
um novo projeto em sua IDE, dentro da pasta "src" importar os arquivos ".java" e dentro da classe
OperacoesCSV na variável "localArquivo" especificar onde o arquivo "alunos.csv" se encontra.

Decisões durante a hora de programação:

    Criação da classe Aluno, CriacaoEmail, EnvioSMS, OperacoesCSV e a PrincipalMail.

    Criação da classe Aluno com os dados contidos no arquivo CSV, como padrão de dados
    dos alunos para esse problema.

    Criação da classe CriacaoEmail com os métodos de criação de possibilidades dos e-mails a 
    partir do nome do aluno, um método que informa ao aluno caso o aluno possua os
    requisitos, as possibilidades de email gerados e captura a escolha do aluno 
    gerando o seu e-mail da UFF e um método de imprimir um ArrayList que contem os e-mails.

    Criação da classe EnvioSMS com uma função que simula o envio de um SMS para o aluno
    após a confirmação da criação do e-mail.

    Criação da classe OperacoesCSV em que na classe possui a função que realiza a leitura
    do arquivo CSV, guarda os dados lidos em um ArrayList e retorna esse ArrayList gerado
    e também possui um método que atualiza o arquivo CSV com as alterações feitas nos cadastros
    dos alunos.

    Criação da PrincipalMail como classe principal para a execução do sistema, chamando os 
    métodos das classes criadas para que o sistema de criação de email com o padrão da UFF
    funcione corretamente.
