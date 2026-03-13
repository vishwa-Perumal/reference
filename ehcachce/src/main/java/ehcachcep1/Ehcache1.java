package ehcachcep1;

import java.time.Duration;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
public class Ehcache1 {

	public static void main(String[] args) throws InterruptedException {
		CacheManager cm = CacheManagerBuilder.newCacheManagerBuilder()
				 .with(CacheManagerBuilder.persistence("D:\\"))
				.build(true);
//		Cache<String,String>cache=cm.createCache("ch1",CacheConfigurationBuilder
//				.newCacheConfigurationBuilder(String.class,String.class,ResourcePoolsBuilder.heap(10))
//						.withExpiry(org.ehcache.config.builders.ExpiryPolicyBuilder
//								.timeToLiveExpiration(Duration.ofMinutes(1))));

		 Cache<String,String> cache = cm.createCache(
	                "ch1",
	                CacheConfigurationBuilder
	                        .newCacheConfigurationBuilder(
	                                String.class,
	                                String.class,

	                                ResourcePoolsBuilder
	                                        .heap(10)
	                                        .disk(50, MemoryUnit.MB, true)
	                        )

	                        .withExpiry(
	                                ExpiryPolicyBuilder
	                                        .timeToLiveExpiration(Duration.ofMinutes(1))
	                        )
	        );
		
		cache.put("otp","123");
		System.out.println(cache.get("otp"));
		Thread.sleep(61*1000);
		System.out.println(cache.get("otp"));
		
	}

}
