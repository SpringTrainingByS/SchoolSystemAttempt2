package pl.dn.service.security.common;

import org.springframework.stereotype.Component;

@Component
public interface TokenExtractor {
	public String extract(String payload);
}
