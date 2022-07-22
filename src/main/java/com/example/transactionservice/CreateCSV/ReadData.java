package com.example.transactionservice.CreateCSV;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import com.example.transactionservice.model.transaction;

@Configuration
@EnableBatchProcessing
public class ReadData {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Value("C:\\Transactions\\2000\\Jan-Mar\\*.csv")
    private Resource[] inputResources;

    @Bean
    public Job readCSVFilesJob() {
        return jobBuilderFactory
                .get("readCSVFilesJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<transaction, transaction>chunk(5)
                .reader(multiResourceItemReader())
                .writer(writer())
                .build();
    }

    @Bean
    public MultiResourceItemReader<transaction> multiResourceItemReader()
    {
        MultiResourceItemReader<transaction> resourceItemReader = new MultiResourceItemReader<transaction>();
        resourceItemReader.setResources(inputResources);
        resourceItemReader.setDelegate(reader());
        return resourceItemReader;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FlatFileItemReader<transaction> reader()
    {
        //Create reader instance
        FlatFileItemReader<transaction> reader = new FlatFileItemReader<transaction>();

        //Set number of lines to skips. Use it if file has header rows.
        reader.setLinesToSkip(1);

        //Configure how each line will be parsed and mapped to different values
        reader.setLineMapper(new DefaultLineMapper() {
            {
                //3 columns in each row
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] { "init_date", "conclusion_date", "product_id", "values" });
                    }
                });
                //Set values in Employee class
                setFieldSetMapper(new BeanWrapperFieldSetMapper<transaction>() {
                    {
                        setTargetType(transaction.class);
                    }
                });
            }
        });
        return reader;
    }

    @Bean
    public ConsoleItemWriter<transaction> writer()
    {
        return new ConsoleItemWriter<transaction>();
    }
    public static void main(String args[])
    {
        ReadData rd = new ReadData();
    }
}
