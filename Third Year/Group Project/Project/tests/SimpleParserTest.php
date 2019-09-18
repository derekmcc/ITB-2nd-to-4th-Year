
<testsuites>
	<testsuite name="mattsmithdev Test Suite">
		<directory>tests</directory>
	</testsuite>
</testsuites>
<filter>
	<whitelist>
		<directory suffix=".php">src/</directory>
	</whitelist>
</filter>
<logging>
	<log type="tap" target="build/report.tap"/>
