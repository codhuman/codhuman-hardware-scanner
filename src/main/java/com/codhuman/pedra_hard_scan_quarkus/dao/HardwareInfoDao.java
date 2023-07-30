package com.codhuman.pedra_hard_scan_quarkus.dao;

import java.util.List;

import com.codhuman.pedra_hard_scan_quarkus.model.HardwareInfo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class HardwareInfoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public HardwareInfo findById(Long id) {
        return entityManager.find(HardwareInfo.class, id);
    }

    public HardwareInfo getHardwareInfoById(int id) {
        // Implementação do acesso aos dados para buscar o registro pelo ID
        // Retorna o registro encontrado ou null se não existir
        // Exemplo fictício:
        return entityManager.find(HardwareInfo.class, id);
    }

    // public HardwareInfo save(HardwareInfo hardwareInfo) {
    // entityManager.persist(hardwareInfo);
    // return hardwareInfo;
    // }

    @Transactional
    public HardwareInfo save(HardwareInfo hardwareInfo) {
        entityManager.persist(hardwareInfo);
        return hardwareInfo;
    }

    // public HardwareInfo save(HardwareInfo hardwareInfo) {
    // EntityTransaction transaction = entityManager.getTransaction();
    // try {
    // transaction.begin();
    // entityManager.persist(hardwareInfo);
    // transaction.commit();
    // } catch (Exception e) {
    // if (transaction.isActive()) {
    // transaction.rollback();
    // }
    // throw e;
    // }
    // return hardwareInfo;
    // }

    public HardwareInfo getHardwareInfo() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HardwareInfo> cq = cb.createQuery(HardwareInfo.class);
        Root<HardwareInfo> rootEntry = cq.from(HardwareInfo.class);
        CriteriaQuery<HardwareInfo> all = cq.select(rootEntry);
        TypedQuery<HardwareInfo> allQuery = entityManager.createQuery(all);
        allQuery.setMaxResults(1); // Define que a consulta deve retornar apenas um resultado
        try {
            return allQuery.getSingleResult();
        } catch (NoResultException e) {
            // Se nenhum resultado for encontrado, retorne null ou trate de acordo com sua
            // lógica de negócio
            return null;
        }
    }

    public List<HardwareInfo> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HardwareInfo> cq = cb.createQuery(HardwareInfo.class);
        Root<HardwareInfo> rootEntry = cq.from(HardwareInfo.class);
        CriteriaQuery<HardwareInfo> all = cq.select(rootEntry);

        TypedQuery<HardwareInfo> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    // outros métodos de CRUD como delete, update, findAll podem ser adicionados...
}
