mvn -Declipse.workspace="C:\NSF\snapviews\PSM_2016\psm-prototype\solicitation-data-service" eclipse:configure-workspace & mvn clean install -Dmaven.test.skip=true & mvn eclipse:eclipse