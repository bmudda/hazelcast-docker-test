package com.bmudda.hazelcast.docker.test;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.nio.Address;

/**
 * 
 * Simple test class to run a Hazelcast instance
 * 
 * @author bonaya.mudda
 *
 */
public class HazelcastRunner {
	
	public static void main(String[] args) throws Exception {
		
		HazelcastInstanceMgr mgr = (new HazelcastRunner()).new HazelcastInstanceMgr();
		mgr.start();
		
		// Sleep for two hours
		Thread.currentThread();
		Thread.sleep(7200000);
		
		
		// shutdown everything
		mgr.shutdown();
		
		System.exit(0);
	}
	
	private class HazelcastInstanceMgr {
		
		private HazelcastInstance hazelcastInstance = null;
		private Config conf = null;
		
		@SuppressWarnings("unused")
		public HazelcastInstanceMgr(String hazelcastConfigFile) {
			this.conf =new ClasspathXmlConfig(hazelcastConfigFile);
		}
		
		public HazelcastInstanceMgr() { }
		
		@SuppressWarnings("unused")
		public HazelcastInstance getInstance() {
			return hazelcastInstance;
		}
		
		public void start() {
			hazelcastInstance = Hazelcast.newHazelcastInstance(conf);
		}
		
		public void shutdown() {
			this.hazelcastInstance.shutdown();
		}
		
		@SuppressWarnings("unused")
		public Address getAddress() {
			return this.hazelcastInstance.getCluster().getLocalMember().getAddress();
		}
		
	}

}
