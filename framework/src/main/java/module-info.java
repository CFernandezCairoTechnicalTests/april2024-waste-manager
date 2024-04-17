module framework {
    requires domain;
    requires application;
    requires static lombok;

    requires spring.core;
    requires spring.context;
    requires spring.beans;
    requires spring.tx;
    /*requires spring.jdbc;
    requires spring.orm;*/
    requires spring.web;

    requires spring.data.jpa;
    requires spring.data.commons;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires org.hibernate.orm.core;
    requires com.fasterxml.jackson.annotation;

    requires spring.boot.autoconfigure;
    requires spring.boot;

    requires io.swagger.v3.oas.models;
    requires io.swagger.v3.oas.annotations;

    requires com.google.common;
    requires org.apache.commons.lang3;
    requires org.slf4j;
    //requires spring.cloud.openfeign.core;

    exports dev.cfernandezcairo.wastemanager.framework.adapters.input.rest.data.manager; //to module spring.beans
    exports dev.cfernandezcairo.wastemanager.framework.adapters.input.rest;
    opens dev.cfernandezcairo.wastemanager.framework.adapters.input.rest;

    opens dev.cfernandezcairo;                                       //open to spring.core
    opens dev.cfernandezcairo.wastemanager.framework.config;
    exports dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.data;
    opens dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.data;
    exports dev.cfernandezcairo.wastemanager.framework.adapters.output.h2;
    opens dev.cfernandezcairo.wastemanager.framework.adapters.output.h2;    //open to spring.core

    provides dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerOutputPort
            with dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.WasteManagerH2Adapter;
    provides dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerAddressOutputPort
            with dev.cfernandezcairo.wastemanager.framework.adapters.output.h2.WasteManagerAddressH2Adapter;

    uses dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerUseCase;
    uses dev.cfernandezcairo.wastemanager.application.usecases.WasteManagerAddressUseCase;
    uses dev.cfernandezcairo.wastemanager.application.usecases.WasteCenterAuthorizationUseCase;
    uses dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerOutputPort;
    uses dev.cfernandezcairo.wastemanager.application.ports.output.WasteManagerAddressOutputPort;
}