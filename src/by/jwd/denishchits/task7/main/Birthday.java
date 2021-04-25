package by.jwd.denishchits.task7.main;

import by.jwd.denishchits.service.IllegalValueException;
import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.service.arguments.CommandLineArgumentException;
import by.jwd.denishchits.service.arguments.CommandLineArgumentUtils;
import by.jwd.denishchits.task7.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

public class Birthday {

    private static final String LOCAL_DATE_PATTERN = "dd.MM.yyyy";

    public static void main(String[] args) {
        try {
            Calendar birthDate = extractBirthDate(args);
            String dayOfWeek = DateUtils.defineDayOfWeek(birthDate);
            String birthDateAsString = extractDateAsString(birthDate);
            System.out.printf("It looks like %s was %s.\n", birthDateAsString, dayOfWeek);
            int age = calculateAge(birthDate);
            System.out.printf("You are %s year(s) old now.\n", age);
            if (DateUtils.isTodayAnnually(birthDate)) {
                System.out.println("Happy birthday!");
            }
        } catch (IllegalValueException | CommandLineArgumentException e) {
            Printer.printErrorMessage(e.getMessage());
        }
    }

    private static int calculateAge(Calendar birthDate) throws IllegalValueException {
        Calendar now = Calendar.getInstance();
        int age = DateUtils.calculateDiffInYears(now, birthDate);
        return age;
    }

    private static String extractDateAsString(Calendar birthDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(LOCAL_DATE_PATTERN);
        String birthDateAsString = dateFormat.format(birthDate.getTime());
        return birthDateAsString;
    }

    private static Calendar extractBirthDate(String[] args)
            throws IllegalValueException, CommandLineArgumentException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(LOCAL_DATE_PATTERN);
        Optional<Calendar> optionalBirthDate = CommandLineArgumentUtils.extractDate(args, dateFormat, 0);
        if (optionalBirthDate.isEmpty()) {
            throw new CommandLineArgumentException("Date was not provided.");
        }
        Calendar birthDate = optionalBirthDate.get();
        return birthDate;
    }
}
