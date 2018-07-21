package pl.dn.security.common;

import org.springframework.stereotype.Component;

@Component
public interface TokenExtractor {
	public String extract(String payload);
}
