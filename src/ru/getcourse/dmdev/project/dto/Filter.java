package ru.getcourse.dmdev.project.dto;

import java.util.Objects;

public class Filter {
    private final int limit;
    private final int offset;
    private final String title;

    public Filter(int limit, int offset, String title) {
        this.limit = limit;
        this.offset = offset;
        this.title = title;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filter filter = (Filter) o;
        return limit == filter.limit && offset == filter.offset && Objects.equals(title, filter.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, offset, title);
    }

    @Override
    public String toString() {
        return "Filter{" +
               "limit=" + limit +
               ", offset=" + offset +
               ", title='" + title + '\'' +
               '}';
    }
}
