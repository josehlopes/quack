package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.AddressDataMapper;
import com.thigas.quack.UseCase.Model.Request.AddressRequestModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class AddressRepository {
    /**
     * Logger usado para registrar mensagens de erro ou informações importantes durante a execução dos métodos.
     */
    private static final Logger logger = LoggerFactory.getLogger(AddressRepository.class);

    /**
     * Gerenciador de entidades do JPA usado para realizar as operações de persistência.
     */
    private final EntityManager entityManager;

    @Transactional
    public void save(AddressDataMapper address) {
        try {
            entityManager.persist(address);
        } catch (Exception e) {
            logger.error("Erro ao salvar endereço: {}", e.getMessage(), e);
        }
    }

    @Transactional
    public void update(AddressDataMapper address) {
        try {
            entityManager.merge(address);
        } catch (Exception e) {
            logger.error("Erro ao atualizar endereço: {}", e.getMessage(), e);
        }
    }

    @Transactional(readOnly = true)
    public Optional<AddressDataMapper> getById(Integer id) {
        try {
            return Optional.ofNullable(entityManager.find(AddressDataMapper.class, id));
        } catch (Exception e) {
            logger.error("Erro ao buscar endereço por ID: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id) {
        try {
            return entityManager.find(AddressDataMapper.class, id) != null;
        } catch (Exception e) {
            logger.error("Erro ao verificar se endereço existe por ID: {}", e.getMessage(), e);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Optional<AddressDataMapper> getUserAddress(Integer userId, Integer addressId) {
        try {
            TypedQuery<AddressDataMapper> query = entityManager.createQuery(
                    "SELECT a FROM AddressDataMapper a WHERE a.user.id = :user_id AND a.id = :address_id", AddressDataMapper.class);
            query.setParameter("user_id", userId);
            query.setParameter("address_id", addressId);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            logger.error("Erro ao buscar endereço do usuário: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Iterable<AddressDataMapper> getAllUserAddresses(Integer userId) {
        try {
            TypedQuery<AddressDataMapper> query = entityManager.createQuery(
                    "SELECT a FROM AddressDataMapper a WHERE a.user.id = :user_id", AddressDataMapper.class);
            query.setParameter("user_id", userId);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao buscar endereços do usuário: {}", e.getMessage(), e);
        }
        return null;
    }

    @Transactional
    public void deleteById(Integer id) {
        try {
            AddressDataMapper user = entityManager.find(AddressDataMapper.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
        } catch (Exception e) {
            logger.error("Erro ao excluir endereço por ID: {}", e.getMessage(), e);
        }
    }

    @Transactional
    public int updateAddressIsActive(Integer id, boolean isActive) {
        try {
            return entityManager.createQuery("UPDATE AddressDataMapper a SET a.isActive = :isActive WHERE a.id = :id")
                    .setParameter("isActive", isActive)
                    .setParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            logger.error("Erro ao atualizar isActive do endereço: {}", e.getMessage(), e);
            return 0;
        }
    }

}
