package br.sapiens.daos;

import br.sapiens.configs.SingletonConnection;
import br.sapiens.domain.enums.CursosEnum;
import br.sapiens.domain.models.Aluno;
import br.sapiens.domain.models.Disciplina;
import br.sapiens.domain.models.Matricula;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class DisciplinaDao implements CrudRepository<Disciplina,Integer> {

    private final Connection conn;

    public DisciplinaDao() throws SQLException {
        this.conn =  new SingletonConnection().getConn();
    }

    @Override
    public <S extends Disciplina> S save(S entity) throws SQLException {
        if(entity.getId() == null)
            return insertInto(entity);
        else
            return update(entity);
    }

    private <S extends Disciplina> S update(S entity) throws SQLException {
        String sql = "UPDATE disciplina SET descricao = ?, curso = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, entity.getDescricao());
        pstmt.setString(2, entity.getCurso().toString());
        pstmt.setInt(3, entity.getId());
        pstmt.executeUpdate();
        return entity;
    }

    private <S extends Disciplina> S insertInto(S entity) throws SQLException {
        String sql = "Insert into disciplina(descricao, curso) values(?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1,entity.getDescricao());
        pstmt.setString(2,entity.getCurso().toString());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows == 0)
            throw new SQLException("Falha, nenhuma linha foi inserida");
        ResultSet generatedKeys = pstmt.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));
        return entity;
    }

    @Override
    public <S extends Disciplina> Iterable<Disciplina> saveAll(Iterable<S> entities) throws SQLException {
        ArrayList lista = new ArrayList();
        for(S entity : entities) {
            lista.add(save(entity));
        }
        return lista;
    }

    @Override
    public Optional<Disciplina> findById(Integer id) throws SQLException {
        List<Disciplina> resultados = findAllById(List.of(id));
        if(resultados == null || resultados.size() != 1)
            throw new SQLException("Erro ao buscar valores, n??o existe somente um resultado! Size "+resultados.size());
        return Optional.ofNullable(resultados.get(0));
    }

    @Override
    public List<Disciplina> findAllById(Iterable<Integer> ids) throws SQLException {
        String sql = "select * from disciplina ";
        if(ids != null) {
            List<Integer> lista = new ArrayList();
            Iterator<Integer> interetor = ids.iterator();
            while(interetor.hasNext()){
                lista.add(interetor.next());
            }
            String sqlIN = lista.stream()
                    .map(x -> String.valueOf(x))
                    .collect(Collectors.joining(",", "(", ")"));
            sql = sql+" where id in(?)".replace("(?)", sqlIN);
        }
        PreparedStatement stmt = conn.prepareStatement(sql);
        List<Disciplina> resultado = new ArrayList();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String descricao = rs.getString(2);
                CursosEnum cursosEnum = CursosEnum.valueOf(rs.getString(3));
                Disciplina disciplina = new Disciplina(id, descricao, cursosEnum);
                resultado.add(disciplina);
            }
        }
        return resultado;
    }



    @Override
    public void delete(Disciplina entity) {

    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void deleteAll(Iterable<? extends Disciplina> entities) {

    }

    public List<Disciplina> findAll() throws SQLException {
        return findAllById(null);
    }
}