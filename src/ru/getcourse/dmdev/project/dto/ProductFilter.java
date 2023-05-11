package ru.getcourse.dmdev.project.dto;

public record ProductFilter (int limit,
                             int offset,
                             String title){
}
