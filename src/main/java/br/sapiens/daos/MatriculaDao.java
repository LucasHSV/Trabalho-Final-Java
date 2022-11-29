package br.sapiens.daos;

import br.sapiens.configs.SingletonConnection;
import br.sapiens.configs.SingletonConnection;
import br.sapiens.domain.enums.PeriodoEnum;
import br.sapiens.domain.models.Disciplina;
import br.sapiens.domain.models.Matricula;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MatriculaDao implements CrudRepository<Matricula, Integer> {
    private final Connection conn;

    public MatriculaDao() throws SQLException {
        this.conn = new SingletonConnection().getConn();
    }

    @Override
    public <S extends Matricula> S save(S entity) throws SQLException {
        return insertInto(entity);
    }


    private <S extends Matricula> S insertInto(S entity) throws SQLException {
        String sql = "Insert into Matricula(disciplinaId, alunoId, periodo) values(?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,entity.getDisciplinaId());
        pstmt.setInt(2,entity.getAlunoId());
        pstmt.setString(3,entity.getPeriodo().toString());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows == 0)
            throw new SQLException("Falha, nenhuma linha foi inserida");
        return entity;
    }

    @Override
    public <S extends Matricula> Iterable<Matricula> saveAll(Iterable<S> entities) throws SQLException {
        return null;
    }

    @Override
    public Optional<Matricula> findById(Integer integer) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Iterable<Matricula> findAllById(Iterable<Integer> ids) throws SQLException {
       return null;
    }

    public List<Matricula> findAllByAlunoId(Iterable<Integer> ids) throws SQLException {
        String sql = "select * from Matricula";
        if(ids != null) {
            List<Integer> lista = new ArrayList();
            Iterator<Integer> interetor = ids.iterator();
            while(interetor.hasNext()){
                lista.add(interetor.next());
            }
            String sqlIN = lista.stream()
                    .map(x -> String.valueOf(x))
                    .collect(Collectors.joining(",", "(", ")"));
            sql = sql+" where alunoId in(?)".replace("(?)", sqlIN);
        }
        PreparedStatement stmt = conn.prepareStatement(sql);
        List<Matricula> resultado = new ArrayList();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int disciplinaId = rs.getInt(1);
                int alunoId = rs.getInt(2);
                PeriodoEnum periodo = PeriodoEnum.valueOf(rs.getString(3));
                Matricula matricula = new Matricula(disciplinaId, alunoId, periodo);
                resultado.add(matricula);
            }
        }
        return resultado;
    }

    @Override
    public void delete(Matricula entity) {
        throw new RuntimeException();
    }

    @Override
    public void deleteById(Integer integer) {
        throw new RuntimeException();
    }

    @Override
    public void deleteAll(Iterable<? extends Matricula> entities) {
        throw new RuntimeException();
    }

    public List<Matricula> findAll() throws SQLException {
        return findAllByAlunoId(null);
    }
}