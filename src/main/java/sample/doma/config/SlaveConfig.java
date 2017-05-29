package sample.doma.config;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.GreedyCacheSqlFileRepository;
import org.seasar.doma.jdbc.NoCacheSqlFileRepository;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by chibana on 2017/05/17.
 */
@SingletonConfig
@Component
public class SlaveConfig implements Config {

    private static final SlaveConfig CONFIG = new SlaveConfig();

    private static final String DATASOURCE_NAME = "slaveDataSource";

    private Dialect dialect;

    private DataSource dataSource;

    private SqlFileRepository sqlFileRepository;

    private SlaveConfig() {
        dialect = new MysqlDialect();
    }

    @Resource(name = "slaveDataSource")
    public void setDataSource(DataSource slaveDataSource) {
        this.dataSource = new TransactionAwareDataSourceProxy(slaveDataSource);
    }

    @Autowired
    public void setSqlFileRepository(@Value("${doma.sql-file-repository}") String policy) {
        if ("no_cache".equals(policy)) {
            this.sqlFileRepository = new NoCacheSqlFileRepository();
        } else {
            this.sqlFileRepository = new GreedyCacheSqlFileRepository();
        }
    }

    @Override
    public String getDataSourceName() {
        return DATASOURCE_NAME;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    public static SlaveConfig singleton() {
        return CONFIG;
    }
}
