# Servlet

- **@ServletComponentScan**
	- 서블릿 구성 요소 (filter, servlet 및 listener)에 대한 스캔을 활성화합니다.
	- 내장 웹 서버를 사용하는 경우에만 스캔이 수행됩니다.
	- 일반적으로 구성 요소를 검색 할 패키지를 제어하려면 value, basePackages 또는 basePackageClasses 중 하나를 지정해야합니다.
	- 부재시 주석이있는 클래스 패키지에서 스캔이 수행된다.
