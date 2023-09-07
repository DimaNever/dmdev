package ru.getcourse.dmdev.homework.week5.part2;

/**
 * Даны 2 класса:
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 * - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив,
 * где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.
 * <p>
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * - добавлять в него новый фильм
 * - получить все фильмы по переданному году
 * - получить все фильмы по переданному году и месяцу
 * - получить все фильмы по переданному жанру
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 * <p>
 * Учесть следующее:
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него
 * (т.е. предусмотреть порядок значения ассоциативного массива)
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */
public class CinemaDemo {

    public static void main(String[] args) {
        Film film1 = new Film(6, 1998, 5, "Comedy", 9.5);
        Film film2 = new Film(2, 2006, 6, "Drama", 8.5);
        Film film3 = new Film(3, 2020, 1, "Action", 7.7);
        Film film4 = new Film(4, 1986, 6, "Comedy", 8.2);
        Film film5 = new Film(5, 2002, 12, "Action", 6.3);
        Film film6 = new Film(1, 1998, 3, "Action", 7.2);
        Film film7 = new Film(1, 2002, 3, "Action", 7.2);

        Cinema cinema = new Cinema();
        cinema.addNewFilm(film1);
        cinema.addNewFilm(film2);
        cinema.addNewFilm(film3);
        cinema.addNewFilm(film4);
        cinema.addNewFilm(film5);
        cinema.addNewFilm(film6);

        System.out.println(cinema);
        cinema.getFilmsOfYear(1998);
        cinema.getFilmsOfYear(1999);
        System.out.println("----------------------------------------------------------------------------");
        cinema.getFilmsOfYearAndMonth(2020, 1);
        cinema.getFilmsOfYearAndMonth(2020, 2);
        System.out.println("----------------------------------------------------------------------------");
        cinema.getFilmsOfGenre("Comedy");
        cinema.getFilmsOfGenre("Fantasy");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(cinema.topList());
        System.out.println("----------------------------------------------------------------------------");
        cinema.addNewFilm(film7);
    }
}
