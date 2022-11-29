package br.sapiens.configs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CriaEntidades {
        public void CriarTabelas(Connection conn) throws SQLException {

            Statement statement = conn.createStatement();

            String matricula = "" +
                    "CREATE TABLE `Matricula` (\n" +
                    "  `disciplinaId` int,\n" +
                    "  `alunoId` int,\n" +
                    "  `periodo` varchar(200),\n" +
                    "  PRIMARY KEY (`disciplinaId`, `alunoId`),\n" +
                    "  FOREIGN KEY (`alunoId`) REFERENCES Aluno(`id`),\n" +
                    "  FOREIGN KEY (`disciplinaId`) REFERENCES Disciplina(`id`)\n" +
                    ");\n";
            String disciplinas = "CREATE TABLE `Disciplina` (\n" +
                    "  `id` bigint auto_increment,\n" +
                    "  `descricao` varchar(200),\n" +
                    "  `curso` varchar(200),\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");\n" +
                    "\n";
            String aluno = "CREATE TABLE `Aluno` (\n" +
                    "  `id` bigint auto_increment,\n" +
                    "  `nome` varchar(200),\n" +
                    "  `dataNascimento` Date,\n" +
                    "  `curso` varchar(200),\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");\n";
            // CHAVES ESTRANGEIRAS CRIADAS

            statement.execute(aluno);
            statement.execute(disciplinas);
            statement.execute(matricula);
            System.out.println("Tabelas criadas com sucesso!");

            statement.close();
        }
}


