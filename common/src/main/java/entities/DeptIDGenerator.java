package entities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class DeptIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String sequenceIdentifier = String.valueOf(getNextValue(sharedSessionContractImplementor, "employee.dpt_id_seq"));
        String deptId = "DEPT_" + StringUtils.leftPad(sequenceIdentifier, 3, '0');
        return deptId;
    }

    public Long getNextValue(SharedSessionContractImplementor sharedSessionContractImplementor, String sequenceName) {
        Connection connection = sharedSessionContractImplementor.connection();
        Long sequenceValue = null;
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT nextval('" + sequenceName + "') AS SEQ");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sequenceValue = resultSet.getLong("SEQ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sequenceValue;
    }
}
