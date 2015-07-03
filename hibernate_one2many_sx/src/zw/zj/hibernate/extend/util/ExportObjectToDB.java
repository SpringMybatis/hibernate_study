package zw.zj.hibernate.extend.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportObjectToDB {

	public static void main(String[] args) {

		// 读取配置文件
//		Configuration config = new Configuration().configure();
//		// 导出配置
//		SchemaExport schemaExport = new SchemaExport(config);
//		/**
//		 * @param script print the DDL to the console(打印到控制台)
//		 * @param export export the script to the database(输出建标语句到数据库)
//		 */
//		schemaExport.create(true, true);
		
		Configuration configuration = new Configuration().configure();
		SchemaExport schemaExport = new SchemaExport(configuration);
		/**
		 * Run the schema creation script.
		 *
		 * @param script print the DDL to the console
		 * @param export export the script to the database
		 */
		schemaExport.create(true, true);
	}

}
