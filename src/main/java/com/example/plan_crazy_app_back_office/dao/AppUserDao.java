package com.example.plan_crazy_app_back_office.dao;

import com.example.plan_crazy_app_back_office.connection.PersistenceManager;
import com.example.plan_crazy_app_back_office.model.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AppUserDao implements Dao<AppUser>{

        EntityManagerFactory emf = (EntityManagerFactory) PersistenceManager.getEntityManager();

@Override
public List<AppUser> findAll() {
        List<AppUser> appUserList = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
        et.begin();
        TypedQuery<AppUser> query = em.createQuery("SELECT b FROM AppUser b", AppUser.class);
        appUserList = query.getResultList();
        et.commit();
        } catch (Exception e) {
        e.printStackTrace();
        if (et.isActive()) {
        et.rollback();
        }
        } finally {
        em.close();
        }
        return appUserList;
        }



@Override
public void create(AppUser appUser) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
        et.begin();
        em.persist(appUser);
        et.commit();
        } catch (Exception e) {
        e.printStackTrace();
        if (et.isActive()) {
        et.rollback();
        }
        } finally {
        em.close();
        }
        }

@Override
public Optional<AppUser> findById(Long appUserId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        System.out.println("Je suis dans le findById");
        System.out.println(appUserId);
        try {
        et.begin();
        AppUser appUser = em.createQuery("SELECT b FROM AppUser b  WHERE b.id = :idParam", AppUser.class)
        .setParameter("idParam", appUserId)
        .getSingleResult();
        et.commit();
        return Optional.of(appUser);
        } catch (Exception e) {
        if (et.isActive()) {
        et.rollback();
        }
        } finally {
        em.close();
        }
        return Optional.empty();
        }


@Override
public void update(AppUser appUserUpdate) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Long id = appUserUpdate.getAppUserId();

        try {
        et.begin();
        AppUser appUser = em.find(AppUser.class, id);

        if (Objects.equals(appUser.getAppUserId(), appUserUpdate.getAppUserId())) {
        appUser.setNickname(appUserUpdate.getNickname());
        appUser.setFirstName(appUserUpdate.getFirstName());
        appUser.setLastName(appUserUpdate.getLastName());
        appUser.setAddress(appUserUpdate.getAddress());
        appUser.setPostcode(appUserUpdate.getPostcode());
        appUser.setCity(appUserUpdate.getCity());
        appUser.setPhoneNumber(appUserUpdate.getPhoneNumber());
        appUser.setEmail(appUserUpdate.getEmail());
        appUser.setPassword(appUserUpdate.getPassword());
        appUser.setAdmin(appUserUpdate.getAdmin());
        }
        et.commit();
        } catch (Exception e) {
        e.printStackTrace();
        if (et.isActive()) {
        et.rollback();
        }
        } finally {
        em.close();
        }
        }


@Override
public void delete(Long appUserId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
        et.begin();
        Optional<AppUser> appUser = Optional.of(em.find(AppUser.class, appUserId));
        appUser.ifPresent(em::remove);
        et.commit();
        } catch (Exception e) {
        e.printStackTrace();
        if (et.isActive()) {
        et.rollback();
        }
        } finally {
        em.close();
        }
        }
        }