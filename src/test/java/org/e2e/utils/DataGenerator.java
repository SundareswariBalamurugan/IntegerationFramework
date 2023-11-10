package org.e2e.utils;

import com.github.javafaker.Faker;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import static java.time.ZoneId.systemDefault;
import static java.util.Locale.ENGLISH;

public class DataGenerator {



        //Field
        private static final String DEFAULT_INDUSTRY = "Finance";
        public static final Faker FAKER = new Faker(ENGLISH);
        private static final int MAX_INCOME = 100000;
        private static final int MIN_INCOME = 10000;
        //Field-End

        //Methods

        /**
         * Generate a date of birth, with a minimum and maximum age.
         *
         * @param minAge minimum age
         * @param maxAge maximum age
         * @return LocalDate object that represents the date of birth
         */
        public static LocalDate generateDateOfBirth(final int minAge, final int maxAge) {
            return convertTFoLocalDate(FAKER.date().birthday(minAge, maxAge));
        }

        /**
         * Generate a date of birth.
         *
         * @return LocalDate object that represents the date of birth
         */
        public static LocalDate generateDateOfBirth() {
            return convertTFoLocalDate(FAKER.date().birthday());
        }


    /**
     * Convert to localDate
     *
     * @return LocalDate object that represents the date of birth
     */
        public static LocalDate convertTFoLocalDate(final Date dateToConvert) {
            return dateToConvert.toInstant().atZone(systemDefault()).toLocalDate();
        }


        /**
         * Generate a random employer industry.
         *
         * @return String that represents the employer industry
         */
        public static String generateEmployerIndustry() {
            // Keep as default as we do not currently support all industries
            return DEFAULT_INDUSTRY;
        }

        /**
         * Generate a random employer name.
         *
         * @return String that represents the employer name
         */
        public static String generateEmployerName() {
            return FAKER.company().name();
        }

        /**
         * Generate a random ID.
         *
         * @return int that represents the first name
         */
        public static int generateID() {
            return FAKER.random().nextInt(10,1000);
        }

        public static long generateLongId(){
            return FAKER.random().nextLong(500000);
        }

    /**
     * Generate a random Dog name name.
     *
     * @return String that represents the first name
     */
    public static String generateDogName() {
        return FAKER.dog().name();
    }

    /**
     * Generate a random first name.
     *
     * @return String that represents the first name
     */
    public static String generateFirstName() {
        return FAKER.name().firstName();
    }

        /**
         * Generate a random annual income using the default minimum and maximum amounts.
         *
         * @return Integer that represents the annual income
         */
        public static Integer generateIncome() {
            return FAKER.number().numberBetween(MIN_INCOME, MAX_INCOME);
        }

        /**
         * Generate a random annual income, with a minimum and maximum amount.
         *
         * @param minIncome minimum income used for the random income generation
         * @param maxIncome maximum income used for the random income generation
         * @return Integer that represents the annual income
         */
        public static Integer generateIncome(final int minIncome, final int maxIncome) {
            return FAKER.number().numberBetween(minIncome, maxIncome);
        }

        /**
         * Generate a random job title.
         *
         * @return String that represents the job title
         */
        public static String generateJobTitle() {
            return FAKER.job().title();
        }

        /**
         * Generate a random last name.
         *
         * @return String that represents the last name
         */
        public static String generateLastName() {
            return FAKER.name().lastName();
        }

        /**
         * Generate a random move in date.
         *
         * @return LocalDate that represents the move in date
         */
        public static LocalDate generateMoveInDate() {
            return convertTFoLocalDate(FAKER.date().birthday());
        }

        /**
         * Generate a random move in date, with a minimum and maximum amount of years in the past.
         *
         * @param minYearsPast minimum amount of years in the past used for the random move in date generation
         * @param maxYearsPast maximum amount of years in the past used for the random move in date generation
         * @return LocalDate that represents the move in date
         */
        public static LocalDate generateMoveInDate(final int minYearsPast, final int maxYearsPast) {
            return convertTFoLocalDate(FAKER.date().birthday(minYearsPast, maxYearsPast));
        }

        /**
         * Generate a random loan term length in months with a minimum and maximum.
         *
         * @param minTermLength minimum number of years for loan
         * @param maxTermLength maximum number of years for loan
         * @return Integer that represents the number of months
         */
        public static Integer generateLoanTermLength(final int minTermLength, final int maxTermLength) {
            return 12 * FAKER.number().numberBetween(minTermLength, maxTermLength);
        }

        /**
         * Generate a random amount to borrow.
         *
         * @param minAmount minimum amount to borrow
         * @param maxAmount maximum amount to borrow
         * @return Float that represents the amount to borrow
         */
        public static Integer generateAmountToBorrow(final int minAmount, final int maxAmount) {
            return FAKER.number().numberBetween(minAmount, maxAmount);
        }

    }


