package by.jwd.denishchits.task7.main;

import by.jwd.denishchits.service.InvalidArgumentException;
import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.service.arguments.CommandLineArgumentException;
import by.jwd.denishchits.service.arguments.CommandLineArgumentUtils;
import by.jwd.denishchits.task7.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

public final class Birthday {

    private static final String LOCAL_DATE_PATTERN = "dd.MM.yyyy";

    private Birthday() {
    }

    public static void main(String[] args) {
        try {
            Calendar birthDate = defineBirthDate(args);
            String dayOfWeek = DateUtils.defineDayOfWeek(birthDate);
            String birthDateAsString = extractDateAsString(birthDate);
            System.out.printf("It looks like %s was %s.\n", birthDateAsString, dayOfWeek);
            int age = calculateAge(birthDate);
            System.out.printf("You are %s year(s) old now.\n", age);
            if (DateUtils.isTodayAnnually(birthDate)) {
                System.out.println("Happy birthday!");
            }
        } catch (InvalidArgumentException | CommandLineArgumentException e) {
            Printer.printErrorMessage(e.getMessage());
        }
    }

    private static int calculateAge(Calendar birthDate) throws InvalidArgumentException {
        Calendar now = Calendar.getInstance();
        int age = DateUtils.calculateDiffInYears(now, birthDate);
        return age;
    }

    private static String extractDateAsString(Calendar birthDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(LOCAL_DATE_PATTERN);
        String birthDateAsString = dateFormat.format(birthDate.getTime());
        return birthDateAsString;
    }

    private static Calendar defineBirthDate(String[] args)
            throws InvalidArgumentException, CommandLineArgumentException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(LOCAL_DATE_PATTERN);
        Optional<Calendar> optionalBirthDate = CommandLineArgumentUtils.extractDate(args, dateFormat, 0);
        if (optionalBirthDate.isEmpty()) {
            throw new CommandLineArgumentException("Date was not provided.");
        }
        Calendar birthDate = optionalBirthDate.get();
        return birthDate;
    }
}
