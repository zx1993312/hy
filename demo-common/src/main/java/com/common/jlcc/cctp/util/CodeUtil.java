package com.common.jlcc.cctp.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

public class CodeUtil {

	// ��������·��
	private static String mapperPath;
	private static String servicePath;
	private static String serviceImplPath;
	private static String controllerPath;

	static {
		// ����·��
		Properties properties = new Properties();
		try {
			properties.load(new InputStreamReader(
					CodeUtil.class.getClassLoader().getResourceAsStream("generator.properties"), "utf-8"));
			mapperPath = properties.getProperty("gen.mapper.path");
			servicePath = properties.getProperty("gen.service.path");
			serviceImplPath = servicePath + "\\impl";
			controllerPath = properties.getProperty("gen.controller.path");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// �������ɵ��Ⱥ�˳��
	private static final String[] paths = { controllerPath, servicePath, serviceImplPath, mapperPath };
	// ģ���Ⱥ�˳��
	private static final String[] templates = { "DomainController.java.vm", "DomainService.java.vm",
			"DomainServiceImpl.java.vm", "DomainMapper.java.vm" };

	// Ҫ���ɵ���Щʵ�������ش���
	private static final String[] domains = { "SysUser" };

	// �Ƿ񸲸�
	private static final boolean FLAG = true;

	@Test
	public void test() throws Exception {

		// ģ��������
		VelocityContext context = new VelocityContext();
		// �������е�domain
		for (String domain : domains) {
			// �õ�domain�����Ĵ�Сд
			String DomainName = domain;
			String domainName = domain.substring(0, 1).toLowerCase() + domain.substring(1);
			// �������������滻����
			context.put("Domain", DomainName);
			context.put("domain", domainName);
			// ����·�����õ�ģ������Ŀ���ļ�
			for (int i = 0; i < paths.length; i++) {

				// ��ʼ������
				Properties properties = new Properties();
				// ����velocity��Դ���ط�ʽΪclass
				properties.setProperty("resource.loader", "class");
				// ����velocity��Դ���ط�ʽΪfileʱ�Ĵ�����
				properties.setProperty("class.resource.loader.class",
						"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
				// ʵ����һ��VelocityEngine����
				VelocityEngine velocityEngine = new VelocityEngine(properties);

				String templateName = templates[i];
				// ���ɴ���
				// ���ɵ��ļ���
				String fileName = templateName.substring(0, templateName.lastIndexOf(".vm"));
				String filePath = paths[i] + "\\" + fileName;
				filePath = filePath.replaceAll("domain", domainName).replaceAll("Domain", DomainName);
				File file = new File(filePath);

				System.out.println(filePath);

				// �ж��Ƿ񸲸Ǵ��ڵ��ļ�
				if (file.exists() && !FLAG) {
					continue;
				}

				// ��ȡ��Ŀ¼
				File parentFile = file.getParentFile();
				if (!parentFile.exists()) {
					parentFile.mkdirs();
				}
				Writer writer = new FileWriter(file);
				// �õ�ģ�壬���ñ���
				velocityEngine.mergeTemplate("template/" + templateName, "utf-8", context, writer);
				writer.close();

			}

		}

	}

}
