package censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;

public class OpenCsvBuilder implements IcsvBuilder{

    public <E>Iterator<E> getCsvFileIterator(Reader reader, Class<E> csvClass) {
        CsvToBean<E> csvToBean;
        Iterator<E> censusCSVIterator;
        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<E>(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        csvToBean = csvToBeanBuilder.build();
        censusCSVIterator = csvToBean.iterator();
        return censusCSVIterator;
    }
}
