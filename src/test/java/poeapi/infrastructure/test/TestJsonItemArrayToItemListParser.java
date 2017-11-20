package poeapi.infrastructure.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.JsonItemArrayToItemListParser;
import poeapi.model.PathOfExileItem;
import poetest.PoeTest;

public class TestJsonItemArrayToItemListParser {

	JsonItemArrayToItemListParser _patient;
	@Before
	public void setUp() throws Exception {
		_patient = new JsonItemArrayToItemListParser();
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
	}
	@Test
	public void test() {
		String json = input();
		List<PathOfExileItem> expected = expectedItems();
		
		List<PathOfExileItem> actual = _patient.getItemsFromJsonItemList(json);
		
		PoeTest.verifyEquals(actual, expected);
	}

	private String input(){
		String json = "{\"numTabs\":18,\"tabs\":[{\"n\":\"1\",\"i\":0,\"id\":\"87928af48c29bf85ae2cdca8ebf42e9038548c6d43ada1416d36ab795c5de3d4\",\"type\":\"NormalStash\",\"hidden\":true,\"selected\":false,\"colour\":{\"r\":124,\"g\":84,\"b\":54},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/OjgxNDgwMjI7fX19\\/535a40fc8b\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/OjgxNDgwMjI7fX19\\/f159e79054\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/OjgxNDgwMjI7fX19\\/21241d0535\\/Stash_TabR.png\"},{\"n\":\"$\",\"i\":1,\"id\":\"2eec512c29a613b869abe7a00b93c107cf07d7d207ee2739f62c9408c04c81e0\",\"type\":\"CurrencyStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"@\",\"i\":2,\"id\":\"d0a0cffa0c5276925ca2291b011f3dcb4856e0e744f29b0c918c0133f5643b62\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":255,\"g\":128,\"b\":223},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0zMjU0NTt9fX0,\\/9aa6ef60b7\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0zMjU0NTt9fX0,\\/0fb4c41aab\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0zMjU0NTt9fX0,\\/d2784cca4f\\/Stash_TabR.png\"},{\"n\":\"0.0\",\"i\":3,\"id\":\"f40cabedc704b136f47a5774b3219e4a724742d08bfa7742629fa58ffb9e9870\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":0,\"g\":0,\"b\":128},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xNjc3NzA4ODt9fX0,\\/7baaab4c91\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xNjc3NzA4ODt9fX0,\\/c6786cda39\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xNjc3NzA4ODt9fX0,\\/997b161859\\/Stash_TabR.png\"},{\"n\":\"3\",\"i\":4,\"id\":\"0b26ea04c9a8038322b65dc7e12526f120c10a97cb2eddc52fff720d6f7126ae\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"cards\",\"i\":5,\"id\":\"cf7b7dbf7cf208844640b80cd97606bb3cfce133eec14ecb3c443ad99d653461\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":255,\"g\":170,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0yMjAxNjt9fX0,\\/7b4a0c09c6\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0yMjAxNjt9fX0,\\/48cdff3a2d\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0yMjAxNjt9fX0,\\/2e84ef10af\\/Stash_TabR.png\"},{\"n\":\"T10+\",\"i\":6,\"id\":\"2ce3872b906e6ee448f0735d0076d809a0eed654279e0383567f8acf5b12151a\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"1\",\"i\":7,\"id\":\"eb51a1a641160be401604091ac6147dad742656e84a20ec11028c4f11bbb020b\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"2\",\"i\":8,\"id\":\"e33c202bb04fd6eaf4548f9eb6138ee9e29f86d9a55843f284783f259a41c3a0\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"sell\",\"i\":9,\"id\":\"fe98a950c8fd51ecb4036b9e10eb664804e9712ee4de30fd1d6796c145412f0c\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"talimans\",\"i\":10,\"id\":\"b5046fdd692385a0514444059aeda637f688033ead8c46c4042c2820daafdb9d\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":115,\"g\":0,\"b\":85},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi05MjQwNDkxO319fQ,,\\/9124912871\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi05MjQwNDkxO319fQ,,\\/25eb8a934b\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi05MjQwNDkxO319fQ,,\\/732ef43793\\/Stash_TabR.png\"},{\"n\":\"?\",\"i\":11,\"id\":\"1ab11ce0cfc99d84657408c0d10fb6a23f9d4209efca212bef5cebb047686f6f\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"4\",\"i\":12,\"id\":\"50aa75df82559f601afafbc6a03151ca94247910346db6cc7aedc0ca380eccad\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":true,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"5\",\"i\":13,\"id\":\"f1d2844fac4376e2a4585c800669075695bd693e29110a03173de7cfedc0f53e\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"6\",\"i\":14,\"id\":\"c83bd5b1a0eb147712d6fa4f068adb8ed2718abe1504401b41046f138e1665e4\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"7\",\"i\":15,\"id\":\"6a77b9f0ac3f928735597821f24677be9a8418c2eb3a88ea06098845c96a0f45\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"8\",\"i\":16,\"id\":\"4e2c7623f8277d6c9929f3a4e16b19e80a058e0169ce3700ad151c2a82ee2ffd\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"},{\"n\":\"9\",\"i\":17,\"id\":\"00e2b085166fda4cb962a9f2be79805471cf44afc1bfb4655c497da8c3695ca6\",\"type\":\"PremiumStash\",\"hidden\":false,\"selected\":false,\"colour\":{\"r\":99,\"g\":128,\"b\":0},\"srcL\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjE7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/c64747b68d\\/Stash_TabL.png\",\"srcC\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjI7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/d6161fcf22\\/Stash_TabC.png\",\"srcR\":\"https:\\/\\/web.poecdn.com\\/gen\\/image\\/YTozOntpOjA7aToyNDtp\\/OjE7czozMjoiMDJhMTk3\\/N2QxZDAzNDQzNmU3NzM5\\/ZjgzZDEzYjIwN2YiO2k6\\/MjthOjI6e2k6MDtpOjI7\\/aToxO2E6Mzp7czoxOiJ0\\/IjtpOjM7czoxOiJuIjtz\\/OjA6IiI7czoxOiJjIjtp\\/Oi0xMDI1NjM4NDt9fX0,\\/1185e76da6\\/Stash_TabR.png\"}],\"items\":[{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":79,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Currency\\/Classic\\/Tempest.png?scale=1&w=1&h=1&v=3ebbe0bdb17945df8cc6eadf7d95e8453\",\"league\":\"Legacy\",\"id\":\"ea365415f0f0252a198ab31b94030cba1994c461e43d2710041550162c0a7347\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"<<set:MS>><<set:M>><<set:S>>Enduring Tempest Leaguestone of Excellence\",\"identified\":true,\"corrupted\":true,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Currently has %0 of %1 Charges\",\"values\":[[\"2\",0],[\"8\",1]],\"displayMode\":3}],\"implicitMods\":[\"Next Area will have a random Tempest, affecting both Monsters and Players\"],\"explicitMods\":[\"+3 to Maximum Charges\",\"39% increased Rarity of Items found in next Area\"],\"descrText\":\"Right-click to open your Legacy Panel and place a Leaguestone in an empty slot. It will apply to the next new area you enter.\",\"frameType\":1,\"x\":1,\"y\":10,\"inventoryId\":\"Stash13\",\"socketedItems\":[]},{\"verified\":false,\"w\":2,\"h\":2,\"ilvl\":84,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Armours\\/Helmets\\/HelmetInt11.png?scale=1&w=2&h=2&v=e785517985bfa266e348519edfc144853\",\"league\":\"Legacy\",\"id\":\"aa48d2608b308f61410c43c82de0284c95bf5165fd715a00b6474e3528327f3d\",\"sockets\":[{\"group\":0,\"attr\":\"I\"}],\"name\":\"<<set:MS>><<set:M>><<set:S>>Demon Ward\",\"typeLine\":\"Hubris Circlet\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Quality\",\"values\":[[\"+11%\",1]],\"displayMode\":0,\"type\":6},{\"name\":\"Energy Shield\",\"values\":[[\"184\",1]],\"displayMode\":0,\"type\":18}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"69\",0]],\"displayMode\":0},{\"name\":\"Int\",\"values\":[[\"154\",0]],\"displayMode\":1}],\"explicitMods\":[\"+71 to maximum Mana\",\"73% increased Energy Shield\",\"+39% to Fire Resistance\",\"+45% to Cold Resistance\",\"22% increased Stun and Block Recovery\"],\"frameType\":2,\"x\":0,\"y\":6,\"inventoryId\":\"Stash13\",\"socketedItems\":[]},{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/IceShield.png?scale=1&w=1&h=1&v=ff757926265cc653abe8e2cbc151931c3\",\"support\":false,\"league\":\"Legacy\",\"id\":\"771d30d6a3998f437037e653e14de4dc2eb8e43bd5d14d820108d7c74321240a\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Arctic Armour\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Spell, Duration, Cold\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Mana Reserved\",\"values\":[[\"25%\",0]],\"displayMode\":0},{\"name\":\"Cooldown Time\",\"values\":[[\"0.50 sec\",0]],\"displayMode\":0},{\"name\":\"Cast Time\",\"values\":[[\"0.50 sec\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+5%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/49725\",0]],\"displayMode\":2,\"progress\":2.01106086024e-5}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"16\",0]],\"displayMode\":0},{\"name\":\"Dex\",\"values\":[[\"26\",0]],\"displayMode\":1},{\"name\":\"Int\",\"values\":[[\"18\",0]],\"displayMode\":1}],\"secDescrText\":\"Summons an icy barrier that chills enemies when they hit you. You drop chilled ground while moving, and take less Fire and Physical damage while stationary.\",\"explicitMods\":[\"Base duration is 2.50 seconds\",\"5% increased Duration \",\"Chill Enemy for 0.5 seconds when Hit\",\"8% less Physical Damage taken when Hit\",\"8% less Fire Damage taken when Hit\"],\"descrText\":\"Place into an item socket of the right colour to gain this skill. Right click to remove from a socket.\",\"frameType\":4,\"x\":2,\"y\":0,\"inventoryId\":\"Stash13\",\"socketedItems\":[]},{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/Support\\/WeaponElementalDamage.png?scale=1&w=1&h=1&v=d4747417db3cc97e4cefa260fa65557f3\",\"support\":true,\"league\":\"Legacy\",\"id\":\"0537bf7649aa3c8ab9e4646540f9fc61e072b94781ba0daf5ec24dca95323f8a\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Weapon Elemental Damage Support\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Attack, Support\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Mana Multiplier\",\"values\":[[\"140%\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+5%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/69833\",0]],\"displayMode\":2,\"progress\":1.43198776641e-5}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"18\",0]],\"displayMode\":0},{\"name\":\"Str\",\"values\":[[\"21\",0]],\"displayMode\":1},{\"name\":\"Int\",\"values\":[[\"14\",0]],\"displayMode\":1}],\"explicitMods\":[\"2% increased Elemental Damage with Weapons\",\"Supported Skills deal 40% more Weapon Elemental Damage\"],\"descrText\":\"This is a Support Gem. It does not grant a bonus to your character, but to skills in sockets connected to it. Place into an item socket connected to a socket containing the Active Skill Gem you wish to augment. Right click to remove from a socket.\",\"frameType\":4,\"x\":0,\"y\":10,\"inventoryId\":\"Stash13\",\"socketedItems\":[]},{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/LeapSlam.png?scale=1&w=1&h=1&v=73d0b5f9f1c52f0e0e87f74a80a549ab3\",\"support\":false,\"league\":\"Legacy\",\"id\":\"28ee6a134ab173abf3719abf39df764ab6d33891f5152a704f2e6a6767428c8b\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Leap Slam\",\"identified\":true,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Attack, AoE, Movement, Melee\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Mana Cost\",\"values\":[[\"15\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+6%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/9569\",0]],\"displayMode\":2,\"progress\":0.000104504128103}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"10\",0]],\"displayMode\":0},{\"name\":\"Str\",\"values\":[[\"29\",0]],\"displayMode\":1}],\"secDescrText\":\"Jump into the air, damaging enemies (and knocking back some) with your main hand where you land. Enemies you would land on are pushed out of the way. Requires an axe, mace, sword or staff.\",\"explicitMods\":[\"23% chance to Knock Enemies Back on hit\"],\"descrText\":\"Place into an item socket of the right colour to gain this skill. Right click to remove from a socket.\",\"frameType\":4,\"x\":0,\"y\":11,\"inventoryId\":\"Stash13\",\"socketedItems\":[]},{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":81,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Jewels\\/basicint.png?scale=1&w=1&h=1&v=cd579ea22c05f1c6ad2fd015d7a710bd3\",\"league\":\"Legacy\",\"id\":\"b7e900ca41556a923f0322fb88af2448fafd00c2534eb220241e050348caf4a9\",\"sockets\":[],\"name\":\"<<set:MS>><<set:M>><<set:S>>Rapture Pillar\",\"typeLine\":\"Cobalt Jewel\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"explicitMods\":[\"1% additional Chance to Block Spells with Staves\",\"14% increased Physical Damage with Staves\",\"+13% to Critical Strike Multiplier for Spells\"],\"descrText\":\"Place into an allocated Jewel Socket on the Passive Skill Tree. Right click to remove from the Socket.\",\"frameType\":2,\"x\":2,\"y\":1,\"inventoryId\":\"Stash13\",\"socketedItems\":[]},{\"verified\":false,\"w\":2,\"h\":3,\"ilvl\":77,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Armours\\/BodyArmours\\/VisMortis.png?scale=1&w=2&h=3&v=d9655cd289589716bb4560bbcc5da0e33\",\"league\":\"Legacy\",\"id\":\"5ad97c9eb916b980442497ef3d067d7b1c06c3552475e385be6765c0ae0c696c\",\"sockets\":[{\"group\":0,\"attr\":\"I\"},{\"group\":0,\"attr\":\"I\"},{\"group\":0,\"attr\":\"I\"},{\"group\":0,\"attr\":\"I\"},{\"group\":0,\"attr\":\"I\"},{\"group\":0,\"attr\":\"I\"}],\"name\":\"<<set:MS>><<set:M>><<set:S>>Vis Mortis\",\"typeLine\":\"Necromancer Silks\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Energy Shield\",\"values\":[[\"379\",1]],\"displayMode\":0,\"type\":18}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"59\",0]],\"displayMode\":0},{\"name\":\"Int\",\"values\":[[\"160\",0]],\"displayMode\":1}],\"explicitMods\":[\"+20 to maximum Mana\",\"203% increased Energy Shield\",\"Minions have 20% reduced maximum Life\",\"Minions deal 15% increased Damage\",\"+1 to maximum number of Spectres\",\"Minions gain Unholy Might for 10 seconds on Kill\"],\"flavourText\":[\"Reap what others have sown\\r\",\"Muster them from their graves\\r\",\"Parade them for your pleasure\\r\",\"Zealots in mortis enslaved\"],\"frameType\":3,\"x\":0,\"y\":0,\"inventoryId\":\"Stash13\",\"socketedItems\":[{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/BlightGem.png?scale=1&w=1&h=1&v=264994d77810e996d64372e2363c7ec53\",\"support\":false,\"id\":\"c85e400a355137bc22f771b1f62898a090f8f3aa6f47aee2a70b7c4d21bb5f1f\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Blight\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Spell, Chaos, AoE, Channelling, Duration\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Mana Cost\",\"values\":[[\"2\",0]],\"displayMode\":0},{\"name\":\"Cast Time\",\"values\":[[\"0.30 sec\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+6%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/70\",0]],\"displayMode\":2,\"progress\":0.0142857143655}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0}],\"secDescrText\":\"Apply a debuff to enemies in front of you which deals chaos damage over time. Enemies who aren't already debuffed by Blight are also hindered for a shorter secondary duration, slowing their movement. Continued channelling adds layers of damage to the debuff, each with their own duration.\",\"explicitMods\":[\"Deals 1.7 Base Chaos Damage per second\",\"Base duration is 2.50 seconds\",\"Base secondary duration is 0.80 seconds\",\"Modifiers to Spell Damage apply to this skill's Damage Over Time\",\"3% increased Area of Effect\",\"80% reduced Movement Speed\",\"Debuff can have up to 20 layers of Damage\"],\"descrText\":\"Place into an item socket of the right colour to gain this skill. Right click to remove from a socket.\",\"frameType\":4,\"socket\":0,\"colour\":\"I\",\"socketedItems\":[]},{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/Support\\/LightningPenetration.png?scale=1&w=1&h=1&v=8de701243b97ffb292780b44d16c27cd3\",\"support\":true,\"id\":\"01204768cd0ba849025e58118d46ec716c1b2577b70e76f44344cf81e1cd0bee\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Lightning Penetration Support\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Lightning, Support\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Mana Multiplier\",\"values\":[[\"140%\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+5%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/285815\",0]],\"displayMode\":2,\"progress\":3.49876677319e-6}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"31\",0]],\"displayMode\":0},{\"name\":\"Int\",\"values\":[[\"52\",0]],\"displayMode\":1}],\"explicitMods\":[\"2% increased Lightning Damage\",\"Supported Skills Penetrate 18% Lightning Resistance\"],\"descrText\":\"This is a Support Gem. It does not grant a bonus to your character, but to skills in sockets connected to it. Place into an item socket connected to a socket containing the Active Skill Gem you wish to augment. Right click to remove from a socket.\",\"frameType\":4,\"socket\":1,\"colour\":\"I\",\"socketedItems\":[]}]},{\"verified\":false,\"w\":2,\"h\":3,\"ilvl\":81,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Armours\\/BodyArmours\\/Illuminatis.png?scale=1&w=2&h=3&v=3addf6a97440c72138dd596e36fa7a1d3\",\"league\":\"Legacy\",\"id\":\"9898a8c73234ec34119c3eb87f047a4f7500e4bf2b6f14b87e1c558174bdf914\",\"sockets\":[{\"group\":0,\"attr\":\"S\"},{\"group\":0,\"attr\":\"I\"},{\"group\":0,\"attr\":\"I\"}],\"name\":\"<<set:MS>><<set:M>><<set:S>>Incandescent Heart\",\"typeLine\":\"Saintly Chainmail\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Quality\",\"values\":[[\"+20%\",1]],\"displayMode\":0,\"type\":6},{\"name\":\"Armour\",\"values\":[[\"1010\",1]],\"displayMode\":0,\"type\":16},{\"name\":\"Energy Shield\",\"values\":[[\"346\",1]],\"displayMode\":0,\"type\":18}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"70\",0]],\"displayMode\":0},{\"name\":\"Str\",\"values\":[[\"99\",0]],\"displayMode\":1},{\"name\":\"Dex\",\"values\":[[\"27\",0]],\"displayMode\":1},{\"name\":\"Int\",\"values\":[[\"115\",0]],\"displayMode\":1}],\"explicitMods\":[\"233% increased Armour and Energy Shield\",\"+82 to maximum Life\",\"0.96% of Attack Damage Leeched as Life\",\"Gain 19% of Elemental Damage as Extra Chaos Damage\",\"25% of Elemental Damage taken as Chaos Damage\",\"28% increased Light Radius\",\"Light Radius is based on Energy Shield instead of Life\"],\"flavourText\":[\"Only light may banish the shadows from this land\\r\",\"And the black lies wrapped around your heart\"],\"frameType\":3,\"x\":0,\"y\":3,\"inventoryId\":\"Stash13\",\"socketedItems\":[{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/Support\\/CastOnDmgTaken.png?scale=1&w=1&h=1&v=e03ceb1a31e457dbfe30e968c76fb0d63\",\"support\":true,\"id\":\"4b1f5c6c5a82cf59f303748f7a10a24a7e36766e84abb4364fe60ba1b650505e\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Cast when Damage Taken Support\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Support, Spell, Trigger\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Cooldown Time\",\"values\":[[\"0.25 sec\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+6%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/388734\",0]],\"displayMode\":2,\"progress\":2.57245324065e-6}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"38\",0]],\"displayMode\":0},{\"name\":\"Str\",\"values\":[[\"39\",0]],\"displayMode\":1},{\"name\":\"Int\",\"values\":[[\"27\",0]],\"displayMode\":1}],\"explicitMods\":[\"3% increased Damage\",\"This Gem can only Support Skill Gems requiring Level 38 or lower\",\"70% less Damage\",\"You cannot Cast Supported Triggerable Spells directly\",\"Casts Supported Spells when you take a total of 528 Damage\"],\"descrText\":\"This is a Support Gem. It does not grant a bonus to your character, but to skills in sockets connected to it. Place into an item socket connected to a socket containing the Active Skill Gem you wish to augment. Right click to remove from a socket.\",\"frameType\":4,\"socket\":0,\"colour\":\"S\",\"socketedItems\":[]},{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/TempestShield.png?scale=1&w=1&h=1&v=d8d34090b1ed5028a29f130836c7da0e3\",\"support\":false,\"id\":\"e4a6bcfabcf5e5d8586a617274191c629ba8d8fd6815d994131979ce2c488bec\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Tempest Shield\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Spell, Lightning, Chaining, Duration\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Mana Cost\",\"values\":[[\"17\",0]],\"displayMode\":0},{\"name\":\"Cast Time\",\"values\":[[\"0.50 sec\",0]],\"displayMode\":0},{\"name\":\"Critical Strike Chance\",\"values\":[[\"6.00%\",0]],\"displayMode\":0},{\"name\":\"Damage Effectiveness\",\"values\":[[\"60%\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+13%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/49725\",0]],\"displayMode\":2,\"progress\":2.01106086024e-5}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"16\",0]],\"displayMode\":0},{\"name\":\"Str\",\"values\":[[\"18\",0]],\"displayMode\":1},{\"name\":\"Int\",\"values\":[[\"26\",0]],\"displayMode\":1}],\"secDescrText\":\"Enchants your shield with the power of storms, which lashes out to deal arcing lightning damage to attackers when you block them. Blocking refreshes the duration of Tempest Shield.\",\"explicitMods\":[\"13% increased Lightning Damage\",\"Deals 24 to 36 Lightning Damage\",\"Base duration is 12.00 seconds\",\"Chain +1 Times\",\"Additional 3% Shield Block Chance\"],\"descrText\":\"Place into an item socket of the right colour to gain this skill. Right click to remove from a socket.\",\"frameType\":4,\"socket\":1,\"colour\":\"I\",\"socketedItems\":[]},{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/Support\\/CastOnStun.png?scale=1&w=1&h=1&v=bf785454a7c1509f18b5055e55c477ae3\",\"support\":true,\"id\":\"a0e746e789003b866107371628f8620cb0529f71a669e489ec398fa4796658ed\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Cast when Stunned Support\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Support, Spell, Trigger\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Cooldown Time\",\"values\":[[\"0.25 sec\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+5%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/388734\",0]],\"displayMode\":2,\"progress\":2.57245324065e-6}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"38\",0]],\"displayMode\":0},{\"name\":\"Dex\",\"values\":[[\"27\",0]],\"displayMode\":1},{\"name\":\"Int\",\"values\":[[\"39\",0]],\"displayMode\":1}],\"explicitMods\":[\"2% increased Damage\",\"You cannot Cast Supported Triggerable Spells directly\",\"50% chance to Cast Supported Spells when you are Stunned, or\\nBlock a Stunning Hit\"],\"descrText\":\"This is a Support Gem. It does not grant a bonus to your character, but to skills in sockets connected to it. Place into an item socket connected to a socket containing the Active Skill Gem you wish to augment. Right click to remove from a socket.\",\"frameType\":4,\"socket\":2,\"colour\":\"I\",\"socketedItems\":[]}]},{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":75,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Jewels\\/GreenJewel5.png?scale=1&w=1&h=1&v=19fb3da924047b975d546d44d3ecfb4a3\",\"league\":\"Legacy\",\"id\":\"be3609ec63600a4c46bf8884510bed698eb9915b7e223a45c5b5cae4273355f7\",\"sockets\":[],\"name\":\"<<set:MS>><<set:M>><<set:S>>Cold Steel\",\"typeLine\":\"Viridian Jewel\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Radius\",\"values\":[[\"Large\",0]],\"displayMode\":0}],\"explicitMods\":[\"Increases and Reductions to Physical Damage in Radius are Transformed to apply to Cold Damage\",\"Increases and Reductions to Cold Damage in Radius are Transformed to apply to Physical Damage\"],\"descrText\":\"Place into an allocated Jewel Socket on the Passive Skill Tree. Right click to remove from the Socket.\",\"flavourText\":[\"Winter provides us with her own weapons,\\r\",\"hanging from the eaves of our homes.\"],\"frameType\":3,\"x\":1,\"y\":11,\"inventoryId\":\"Stash13\",\"socketedItems\":[]},{\"verified\":false,\"w\":2,\"h\":2,\"ilvl\":78,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Armours\\/Boots\\/TwoTonedBoots3B.png?scale=1&w=2&h=2&v=be244f0640954c1c79656ff79fcfc79f3\",\"league\":\"Legacy\",\"id\":\"82d964a24029967cd15cfa0444bc7bffdeff7bce798f77c3adcf6be05dc1b6ba\",\"sockets\":[{\"group\":0,\"attr\":\"I\"},{\"group\":0,\"attr\":\"I\"},{\"group\":0,\"attr\":\"S\"},{\"group\":0,\"attr\":\"S\"}],\"name\":\"<<set:MS>><<set:M>><<set:S>>Viper Stride\",\"typeLine\":\"Two-Toned Boots\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Armour\",\"values\":[[\"165\",1]],\"displayMode\":0,\"type\":16},{\"name\":\"Energy Shield\",\"values\":[[\"59\",1]],\"displayMode\":0,\"type\":18}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"72\",0]],\"displayMode\":0},{\"name\":\"Str\",\"values\":[[\"67\",0]],\"displayMode\":1},{\"name\":\"Dex\",\"values\":[[\"27\",0]],\"displayMode\":1},{\"name\":\"Int\",\"values\":[[\"62\",0]],\"displayMode\":1}],\"implicitMods\":[\"+19% to Fire and Lightning Resistances\"],\"explicitMods\":[\"51% increased Armour and Energy Shield\",\"+7 to maximum Energy Shield\",\"+21% to Fire Resistance\",\"+43% to Lightning Resistance\",\"20% increased Movement Speed\",\"40% increased Stun and Block Recovery\"],\"frameType\":2,\"x\":0,\"y\":8,\"inventoryId\":\"Stash13\",\"socketedItems\":[{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/Support\\/CastWhileChanneling.png?scale=1&w=1&h=1&v=2efa1f150e15467041775cd5eba6a2d03\",\"support\":true,\"id\":\"aee02afb2687d5aa2049e2ef01458528bd1f17f608e2674813fabfa478fd447d\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Cast while Channelling Support\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Support, Channelling, Spell\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Mana Multiplier\",\"values\":[[\"140%\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+6%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/388734\",0]],\"displayMode\":2,\"progress\":2.57245324065e-6}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"38\",0]],\"displayMode\":0},{\"name\":\"Dex\",\"values\":[[\"27\",0]],\"displayMode\":1},{\"name\":\"Int\",\"values\":[[\"39\",0]],\"displayMode\":1}],\"explicitMods\":[\"3% increased Damage\",\"You cannot Cast Supported Triggerable Spells directly\",\"Cast a Supported Spell every 0.45 seconds while Channelling Supported Skills\"],\"descrText\":\"This is a Support Gem. It does not grant a bonus to your character, but to skills in sockets connected to it. Place into an item socket connected to a socket containing the Active Skill Gem you wish to augment. Right click to remove from a socket.\",\"frameType\":4,\"socket\":0,\"colour\":\"I\",\"socketedItems\":[]},{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/FireNovaMineGem.png?scale=1&w=1&h=1&v=68cbcf04cd61ed4623d62638e8804d493\",\"support\":false,\"id\":\"1829beb569bf1012cff5cfc4bf513d85222f48ff60275d7c751ea3a301719334\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Fire Nova Mine\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"AoE, Mine, Spell, Fire, Duration\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Mana Cost\",\"values\":[[\"12\",0]],\"displayMode\":0},{\"name\":\"Cast Time\",\"values\":[[\"0.40 sec\",0]],\"displayMode\":0},{\"name\":\"Critical Strike Chance\",\"values\":[[\"5.00%\",0]],\"displayMode\":0},{\"name\":\"Damage Effectiveness\",\"values\":[[\"30%\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+5%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/15249\",0]],\"displayMode\":2,\"progress\":6.55780677334e-5}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"12\",0]],\"displayMode\":0},{\"name\":\"Int\",\"values\":[[\"33\",0]],\"displayMode\":1}],\"secDescrText\":\"Lay a remote mine that you can detonate to create a series of fire novas. Each sequential nova from the same mine will do higher damage than the previous.\",\"explicitMods\":[\"Deals 6 to 9 Fire Damage\",\"Mine lasts 16 seconds\",\"Spell Repeats 3 times\",\"5% increased Fire Damage\",\"20% more Damage per Repeat\"],\"descrText\":\"Place into an item socket of the right colour to gain this skill. Right click to remove from a socket.\",\"frameType\":4,\"socket\":1,\"colour\":\"I\",\"socketedItems\":[]},{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/Support\\/LifeonHit.png?scale=1&w=1&h=1&v=1a15d95d5d29c1d1b92e3ad0193028a83\",\"support\":true,\"id\":\"a55858a6ce2273ddf2995ed4b9308c65f84dfd842a669f04138c4fd409c69cd0\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Life Gain on Hit Support\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Attack, Support\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Mana Multiplier\",\"values\":[[\"150%\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+13%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/3231\",0]],\"displayMode\":2,\"progress\":0.000309501716401}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"8\",0]],\"displayMode\":0},{\"name\":\"Str\",\"values\":[[\"18\",0]],\"displayMode\":1}],\"explicitMods\":[\"+12 Life gained for each enemy hit by Supported Attack\"],\"descrText\":\"This is a Support Gem. It does not grant a bonus to your character, but to skills in sockets connected to it. Place into an item socket connected to a socket containing the Active Skill Gem you wish to augment. Right click to remove from a socket.\",\"frameType\":4,\"socket\":2,\"colour\":\"S\",\"socketedItems\":[]},{\"verified\":false,\"w\":1,\"h\":1,\"ilvl\":0,\"icon\":\"https:\\/\\/web.poecdn.com\\/image\\/Art\\/2DItems\\/Gems\\/ShockwaveTotem.png?scale=1&w=1&h=1&v=241110bff96e067e447f055ed2a13b8d3\",\"support\":false,\"id\":\"bf61dee33725e246906846ffa06cf0b4e5d10543d718b03288a8eab2c3f395c0\",\"sockets\":[],\"name\":\"\",\"typeLine\":\"Shockwave Totem\",\"identified\":true,\"corrupted\":false,\"lockedToCharacter\":false,\"properties\":[{\"name\":\"Totem, Spell, AoE, Duration\",\"values\":[],\"displayMode\":0},{\"name\":\"Level\",\"values\":[[\"1\",0]],\"displayMode\":0,\"type\":5},{\"name\":\"Mana Cost\",\"values\":[[\"24\",0]],\"displayMode\":0},{\"name\":\"Cast Time\",\"values\":[[\"0.60 sec\",0]],\"displayMode\":0},{\"name\":\"Critical Strike Chance\",\"values\":[[\"5.00%\",0]],\"displayMode\":0},{\"name\":\"Damage Effectiveness\",\"values\":[[\"60%\",0]],\"displayMode\":0},{\"name\":\"Quality\",\"values\":[[\"+5%\",1]],\"displayMode\":0,\"type\":6}],\"additionalProperties\":[{\"name\":\"Experience\",\"values\":[[\"1\\/199345\",0]],\"displayMode\":2,\"progress\":5.01642898598e-6}],\"requirements\":[{\"name\":\"Level\",\"values\":[[\"28\",0]],\"displayMode\":0},{\"name\":\"Str\",\"values\":[[\"67\",0]],\"displayMode\":1}],\"secDescrText\":\"Summons a totem that shakes the earth around it, knocking back and damaging nearby enemies\",\"explicitMods\":[\"Deals 23 to 46 Physical Damage\",\"25% chance to Knock Enemies Back on hit\",\"Totem lasts 8 seconds\",\"Summons a Totem which uses this Skill\",\"5% increased totem life\"],\"descrText\":\"Place into an item socket of the right colour to gain this skill. Right click to remove from a socket.\",\"frameType\":4,\"socket\":3,\"colour\":\"S\",\"socketedItems\":[]}]}]}";
		return json;
	}
	
	private List<PathOfExileItem> expectedItems(){
		List<PathOfExileItem> items = new ArrayList<PathOfExileItem>();

		int width0 = 1;
		int height0 = 1;
		int itemLevel0 = 79;
		String icon0 = "https://web.poecdn.com/image/Art/2DItems/Currency/Classic/Tempest.png?scale=1&w=1&h=1&v=3ebbe0bdb17945df8cc6eadf7d95e8453";
		boolean sixLink0 = false;
		String name0 = "";
		String typeLine0 = "<<set:MS>><<set:M>><<set:S>>Enduring Tempest Leaguestone of Excellence";
		boolean corrupted0 = true;
		boolean identified0 = true;
		List<String> implicitMods0 = new ArrayList<String>();
		implicitMods0.add(new String("Next Area will have a random Tempest, affecting both Monsters and Players"));
		List<String> explicitMods0 = new ArrayList<String>();
		explicitMods0.add(new String("+3 to Maximum Charges"));
		explicitMods0.add(new String("39% increased Rarity of Items found in next Area"));
		int xLocation0 = 1;
		int yLocation0 = 10;
		List<PathOfExileItem> socketedItems0 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem0 = new PathOfExileItem(
			width0,
			height0,
			itemLevel0,
			icon0,
			sixLink0,
			name0,
			typeLine0,
			corrupted0,
			identified0,
			implicitMods0,
			explicitMods0,
			xLocation0,
			yLocation0,
			socketedItems0
		);
		items.add(expectedItem0);

		int width1 = 2;
		int height1 = 2;
		int itemLevel1 = 84;
		String icon1 = "https://web.poecdn.com/image/Art/2DItems/Armours/Helmets/HelmetInt11.png?scale=1&w=2&h=2&v=e785517985bfa266e348519edfc144853";
		boolean sixLink1 = false;
		String name1 = "<<set:MS>><<set:M>><<set:S>>Demon Ward";
		String typeLine1 = "Hubris Circlet";
		boolean corrupted1 = false;
		boolean identified1 = true;
		List<String> implicitMods1 = new ArrayList<String>();
		List<String> explicitMods1 = new ArrayList<String>();
		explicitMods1.add(new String("+71 to maximum Mana"));
		explicitMods1.add(new String("73% increased Energy Shield"));
		explicitMods1.add(new String("+39% to Fire Resistance"));
		explicitMods1.add(new String("+45% to Cold Resistance"));
		explicitMods1.add(new String("22% increased Stun and Block Recovery"));
		int xLocation1 = 0;
		int yLocation1 = 6;
		List<PathOfExileItem> socketedItems1 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem1 = new PathOfExileItem(
			width1,
			height1,
			itemLevel1,
			icon1,
			sixLink1,
			name1,
			typeLine1,
			corrupted1,
			identified1,
			implicitMods1,
			explicitMods1,
			xLocation1,
			yLocation1,
			socketedItems1
		);
		items.add(expectedItem1);

		int width2 = 1;
		int height2 = 1;
		int itemLevel2 = 0;
		String icon2 = "https://web.poecdn.com/image/Art/2DItems/Gems/IceShield.png?scale=1&w=1&h=1&v=ff757926265cc653abe8e2cbc151931c3";
		boolean sixLink2 = false;
		String name2 = "";
		String typeLine2 = "Arctic Armour";
		boolean corrupted2 = false;
		boolean identified2 = true;
		List<String> implicitMods2 = new ArrayList<String>();
		List<String> explicitMods2 = new ArrayList<String>();
		explicitMods2.add(new String("Base duration is 2.50 seconds"));
		explicitMods2.add(new String("5% increased Duration "));
		explicitMods2.add(new String("Chill Enemy for 0.5 seconds when Hit"));
		explicitMods2.add(new String("8% less Physical Damage taken when Hit"));
		explicitMods2.add(new String("8% less Fire Damage taken when Hit"));
		int xLocation2 = 2;
		int yLocation2 = 0;
		List<PathOfExileItem> socketedItems2 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem2 = new PathOfExileItem(
			width2,
			height2,
			itemLevel2,
			icon2,
			sixLink2,
			name2,
			typeLine2,
			corrupted2,
			identified2,
			implicitMods2,
			explicitMods2,
			xLocation2,
			yLocation2,
			socketedItems2
		);
		items.add(expectedItem2);

		int width3 = 1;
		int height3 = 1;
		int itemLevel3 = 0;
		String icon3 = "https://web.poecdn.com/image/Art/2DItems/Gems/Support/WeaponElementalDamage.png?scale=1&w=1&h=1&v=d4747417db3cc97e4cefa260fa65557f3";
		boolean sixLink3 = false;
		String name3 = "";
		String typeLine3 = "Weapon Elemental Damage Support";
		boolean corrupted3 = false;
		boolean identified3 = true;
		List<String> implicitMods3 = new ArrayList<String>();
		List<String> explicitMods3 = new ArrayList<String>();
		explicitMods3.add(new String("2% increased Elemental Damage with Weapons"));
		explicitMods3.add(new String("Supported Skills deal 40% more Weapon Elemental Damage"));
		int xLocation3 = 0;
		int yLocation3 = 10;
		List<PathOfExileItem> socketedItems3 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem3 = new PathOfExileItem(
			width3,
			height3,
			itemLevel3,
			icon3,
			sixLink3,
			name3,
			typeLine3,
			corrupted3,
			identified3,
			implicitMods3,
			explicitMods3,
			xLocation3,
			yLocation3,
			socketedItems3
		);
		items.add(expectedItem3);

		int width4 = 1;
		int height4 = 1;
		int itemLevel4 = 0;
		String icon4 = "https://web.poecdn.com/image/Art/2DItems/Gems/LeapSlam.png?scale=1&w=1&h=1&v=73d0b5f9f1c52f0e0e87f74a80a549ab3";
		boolean sixLink4 = false;
		String name4 = "";
		String typeLine4 = "Leap Slam";
		boolean corrupted4 = false;
		boolean identified4 = true;
		List<String> implicitMods4 = new ArrayList<String>();
		List<String> explicitMods4 = new ArrayList<String>();
		explicitMods4.add(new String("23% chance to Knock Enemies Back on hit"));
		int xLocation4 = 0;
		int yLocation4 = 11;
		List<PathOfExileItem> socketedItems4 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem4 = new PathOfExileItem(
			width4,
			height4,
			itemLevel4,
			icon4,
			sixLink4,
			name4,
			typeLine4,
			corrupted4,
			identified4,
			implicitMods4,
			explicitMods4,
			xLocation4,
			yLocation4,
			socketedItems4
		);
		items.add(expectedItem4);

		int width5 = 1;
		int height5 = 1;
		int itemLevel5 = 81;
		String icon5 = "https://web.poecdn.com/image/Art/2DItems/Jewels/basicint.png?scale=1&w=1&h=1&v=cd579ea22c05f1c6ad2fd015d7a710bd3";
		boolean sixLink5 = false;
		String name5 = "<<set:MS>><<set:M>><<set:S>>Rapture Pillar";
		String typeLine5 = "Cobalt Jewel";
		boolean corrupted5 = false;
		boolean identified5 = true;
		List<String> implicitMods5 = new ArrayList<String>();
		List<String> explicitMods5 = new ArrayList<String>();
		explicitMods5.add(new String("1% additional Chance to Block Spells with Staves"));
		explicitMods5.add(new String("14% increased Physical Damage with Staves"));
		explicitMods5.add(new String("+13% to Critical Strike Multiplier for Spells"));
		int xLocation5 = 2;
		int yLocation5 = 1;
		List<PathOfExileItem> socketedItems5 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem5 = new PathOfExileItem(
			width5,
			height5,
			itemLevel5,
			icon5,
			sixLink5,
			name5,
			typeLine5,
			corrupted5,
			identified5,
			implicitMods5,
			explicitMods5,
			xLocation5,
			yLocation5,
			socketedItems5
		);
		items.add(expectedItem5);

		int width6 = 2;
		int height6 = 3;
		int itemLevel6 = 77;
		String icon6 = "https://web.poecdn.com/image/Art/2DItems/Armours/BodyArmours/VisMortis.png?scale=1&w=2&h=3&v=d9655cd289589716bb4560bbcc5da0e33";
		boolean sixLink6 = true;
		String name6 = "<<set:MS>><<set:M>><<set:S>>Vis Mortis";
		String typeLine6 = "Necromancer Silks";
		boolean corrupted6 = false;
		boolean identified6 = true;
		List<String> implicitMods6 = new ArrayList<String>();
		List<String> explicitMods6 = new ArrayList<String>();
		explicitMods6.add(new String("+20 to maximum Mana"));
		explicitMods6.add(new String("203% increased Energy Shield"));
		explicitMods6.add(new String("Minions have 20% reduced maximum Life"));
		explicitMods6.add(new String("Minions deal 15% increased Damage"));
		explicitMods6.add(new String("+1 to maximum number of Spectres"));
		explicitMods6.add(new String("Minions gain Unholy Might for 10 seconds on Kill"));
		int xLocation6 = 0;
		int yLocation6 = 0;
		List<PathOfExileItem> socketedItems6 = new ArrayList<PathOfExileItem>();
		int width7 = 1;
		int height7 = 1;
		int itemLevel7 = 0;
		String icon7 = "https://web.poecdn.com/image/Art/2DItems/Gems/BlightGem.png?scale=1&w=1&h=1&v=264994d77810e996d64372e2363c7ec53";
		boolean sixLink7 = false;
		String name7 = "";
		String typeLine7 = "Blight";
		boolean corrupted7 = false;
		boolean identified7 = true;
		List<String> implicitMods7 = new ArrayList<String>();
		List<String> explicitMods7 = new ArrayList<String>();
		explicitMods7.add(new String("Deals 1.7 Base Chaos Damage per second"));
		explicitMods7.add(new String("Base duration is 2.50 seconds"));
		explicitMods7.add(new String("Base secondary duration is 0.80 seconds"));
		explicitMods7.add(new String("Modifiers to Spell Damage apply to this skill's Damage Over Time"));
		explicitMods7.add(new String("3% increased Area of Effect"));
		explicitMods7.add(new String("80% reduced Movement Speed"));
		explicitMods7.add(new String("Debuff can have up to 20 layers of Damage"));
		int xLocation7 = -1;
		int yLocation7 = -1;
		List<PathOfExileItem> socketedItems7 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem7 = new PathOfExileItem(
			width7,
			height7,
			itemLevel7,
			icon7,
			sixLink7,
			name7,
			typeLine7,
			corrupted7,
			identified7,
			implicitMods7,
			explicitMods7,
			xLocation7,
			yLocation7,
			socketedItems7
		);
		socketedItems6.add(expectedItem7);
		int width8 = 1;
		int height8 = 1;
		int itemLevel8 = 0;
		String icon8 = "https://web.poecdn.com/image/Art/2DItems/Gems/Support/LightningPenetration.png?scale=1&w=1&h=1&v=8de701243b97ffb292780b44d16c27cd3";
		boolean sixLink8 = false;
		String name8 = "";
		String typeLine8 = "Lightning Penetration Support";
		boolean corrupted8 = false;
		boolean identified8 = true;
		List<String> implicitMods8 = new ArrayList<String>();
		List<String> explicitMods8 = new ArrayList<String>();
		explicitMods8.add(new String("2% increased Lightning Damage"));
		explicitMods8.add(new String("Supported Skills Penetrate 18% Lightning Resistance"));
		int xLocation8 = -1;
		int yLocation8 = -1;
		List<PathOfExileItem> socketedItems8 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem8 = new PathOfExileItem(
			width8,
			height8,
			itemLevel8,
			icon8,
			sixLink8,
			name8,
			typeLine8,
			corrupted8,
			identified8,
			implicitMods8,
			explicitMods8,
			xLocation8,
			yLocation8,
			socketedItems8
		);
		socketedItems6.add(expectedItem8);
		PathOfExileItem expectedItem6 = new PathOfExileItem(
			width6,
			height6,
			itemLevel6,
			icon6,
			sixLink6,
			name6,
			typeLine6,
			corrupted6,
			identified6,
			implicitMods6,
			explicitMods6,
			xLocation6,
			yLocation6,
			socketedItems6
		);
		items.add(expectedItem6);

		int width9 = 2;
		int height9 = 3;
		int itemLevel9 = 81;
		String icon9 = "https://web.poecdn.com/image/Art/2DItems/Armours/BodyArmours/Illuminatis.png?scale=1&w=2&h=3&v=3addf6a97440c72138dd596e36fa7a1d3";
		boolean sixLink9 = false;
		String name9 = "<<set:MS>><<set:M>><<set:S>>Incandescent Heart";
		String typeLine9 = "Saintly Chainmail";
		boolean corrupted9 = false;
		boolean identified9 = true;
		List<String> implicitMods9 = new ArrayList<String>();
		List<String> explicitMods9 = new ArrayList<String>();
		explicitMods9.add(new String("233% increased Armour and Energy Shield"));
		explicitMods9.add(new String("+82 to maximum Life"));
		explicitMods9.add(new String("0.96% of Attack Damage Leeched as Life"));
		explicitMods9.add(new String("Gain 19% of Elemental Damage as Extra Chaos Damage"));
		explicitMods9.add(new String("25% of Elemental Damage taken as Chaos Damage"));
		explicitMods9.add(new String("28% increased Light Radius"));
		explicitMods9.add(new String("Light Radius is based on Energy Shield instead of Life"));
		int xLocation9 = 0;
		int yLocation9 = 3;
		List<PathOfExileItem> socketedItems9 = new ArrayList<PathOfExileItem>();
		int width10 = 1;
		int height10 = 1;
		int itemLevel10 = 0;
		String icon10 = "https://web.poecdn.com/image/Art/2DItems/Gems/Support/CastOnDmgTaken.png?scale=1&w=1&h=1&v=e03ceb1a31e457dbfe30e968c76fb0d63";
		boolean sixLink10 = false;
		String name10 = "";
		String typeLine10 = "Cast when Damage Taken Support";
		boolean corrupted10 = false;
		boolean identified10 = true;
		List<String> implicitMods10 = new ArrayList<String>();
		List<String> explicitMods10 = new ArrayList<String>();
		explicitMods10.add(new String("3% increased Damage"));
		explicitMods10.add(new String("This Gem can only Support Skill Gems requiring Level 38 or lower"));
		explicitMods10.add(new String("70% less Damage"));
		explicitMods10.add(new String("You cannot Cast Supported Triggerable Spells directly"));
		explicitMods10.add(new String("Casts Supported Spells when you take a total of 528 Damage"));
		int xLocation10 = -1;
		int yLocation10 = -1;
		List<PathOfExileItem> socketedItems10 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem10 = new PathOfExileItem(
			width10,
			height10,
			itemLevel10,
			icon10,
			sixLink10,
			name10,
			typeLine10,
			corrupted10,
			identified10,
			implicitMods10,
			explicitMods10,
			xLocation10,
			yLocation10,
			socketedItems10
		);
		socketedItems9.add(expectedItem10);
		int width11 = 1;
		int height11 = 1;
		int itemLevel11 = 0;
		String icon11 = "https://web.poecdn.com/image/Art/2DItems/Gems/TempestShield.png?scale=1&w=1&h=1&v=d8d34090b1ed5028a29f130836c7da0e3";
		boolean sixLink11 = false;
		String name11 = "";
		String typeLine11 = "Tempest Shield";
		boolean corrupted11 = false;
		boolean identified11 = true;
		List<String> implicitMods11 = new ArrayList<String>();
		List<String> explicitMods11 = new ArrayList<String>();
		explicitMods11.add(new String("13% increased Lightning Damage"));
		explicitMods11.add(new String("Deals 24 to 36 Lightning Damage"));
		explicitMods11.add(new String("Base duration is 12.00 seconds"));
		explicitMods11.add(new String("Chain +1 Times"));
		explicitMods11.add(new String("Additional 3% Shield Block Chance"));
		int xLocation11 = -1;
		int yLocation11 = -1;
		List<PathOfExileItem> socketedItems11 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem11 = new PathOfExileItem(
			width11,
			height11,
			itemLevel11,
			icon11,
			sixLink11,
			name11,
			typeLine11,
			corrupted11,
			identified11,
			implicitMods11,
			explicitMods11,
			xLocation11,
			yLocation11,
			socketedItems11
		);
		socketedItems9.add(expectedItem11);
		int width12 = 1;
		int height12 = 1;
		int itemLevel12 = 0;
		String icon12 = "https://web.poecdn.com/image/Art/2DItems/Gems/Support/CastOnStun.png?scale=1&w=1&h=1&v=bf785454a7c1509f18b5055e55c477ae3";
		boolean sixLink12 = false;
		String name12 = "";
		String typeLine12 = "Cast when Stunned Support";
		boolean corrupted12 = false;
		boolean identified12 = true;
		List<String> implicitMods12 = new ArrayList<String>();
		List<String> explicitMods12 = new ArrayList<String>();
		explicitMods12.add(new String("2% increased Damage"));
		explicitMods12.add(new String("You cannot Cast Supported Triggerable Spells directly"));
		explicitMods12.add(new String("50% chance to Cast Supported Spells when you are Stunned, or Block a Stunning Hit"));
		int xLocation12 = -1;
		int yLocation12 = -1;
		List<PathOfExileItem> socketedItems12 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem12 = new PathOfExileItem(
			width12,
			height12,
			itemLevel12,
			icon12,
			sixLink12,
			name12,
			typeLine12,
			corrupted12,
			identified12,
			implicitMods12,
			explicitMods12,
			xLocation12,
			yLocation12,
			socketedItems12
		);
		socketedItems9.add(expectedItem12);
		PathOfExileItem expectedItem9 = new PathOfExileItem(
			width9,
			height9,
			itemLevel9,
			icon9,
			sixLink9,
			name9,
			typeLine9,
			corrupted9,
			identified9,
			implicitMods9,
			explicitMods9,
			xLocation9,
			yLocation9,
			socketedItems9
		);
		items.add(expectedItem9);

		int width13 = 1;
		int height13 = 1;
		int itemLevel13 = 75;
		String icon13 = "https://web.poecdn.com/image/Art/2DItems/Jewels/GreenJewel5.png?scale=1&w=1&h=1&v=19fb3da924047b975d546d44d3ecfb4a3";
		boolean sixLink13 = false;
		String name13 = "<<set:MS>><<set:M>><<set:S>>Cold Steel";
		String typeLine13 = "Viridian Jewel";
		boolean corrupted13 = false;
		boolean identified13 = true;
		List<String> implicitMods13 = new ArrayList<String>();
		List<String> explicitMods13 = new ArrayList<String>();
		explicitMods13.add(new String("Increases and Reductions to Physical Damage in Radius are Transformed to apply to Cold Damage"));
		explicitMods13.add(new String("Increases and Reductions to Cold Damage in Radius are Transformed to apply to Physical Damage"));
		int xLocation13 = 1;
		int yLocation13 = 11;
		List<PathOfExileItem> socketedItems13 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem13 = new PathOfExileItem(
			width13,
			height13,
			itemLevel13,
			icon13,
			sixLink13,
			name13,
			typeLine13,
			corrupted13,
			identified13,
			implicitMods13,
			explicitMods13,
			xLocation13,
			yLocation13,
			socketedItems13
		);
		items.add(expectedItem13);

		int width14 = 2;
		int height14 = 2;
		int itemLevel14 = 78;
		String icon14 = "https://web.poecdn.com/image/Art/2DItems/Armours/Boots/TwoTonedBoots3B.png?scale=1&w=2&h=2&v=be244f0640954c1c79656ff79fcfc79f3";
		boolean sixLink14 = false;
		String name14 = "<<set:MS>><<set:M>><<set:S>>Viper Stride";
		String typeLine14 = "Two-Toned Boots";
		boolean corrupted14 = false;
		boolean identified14 = true;
		List<String> implicitMods14 = new ArrayList<String>();
		implicitMods14.add(new String("+19% to Fire and Lightning Resistances"));
		List<String> explicitMods14 = new ArrayList<String>();
		explicitMods14.add(new String("51% increased Armour and Energy Shield"));
		explicitMods14.add(new String("+7 to maximum Energy Shield"));
		explicitMods14.add(new String("+21% to Fire Resistance"));
		explicitMods14.add(new String("+43% to Lightning Resistance"));
		explicitMods14.add(new String("20% increased Movement Speed"));
		explicitMods14.add(new String("40% increased Stun and Block Recovery"));
		int xLocation14 = 0;
		int yLocation14 = 8;
		List<PathOfExileItem> socketedItems14 = new ArrayList<PathOfExileItem>();
		int width15 = 1;
		int height15 = 1;
		int itemLevel15 = 0;
		String icon15 = "https://web.poecdn.com/image/Art/2DItems/Gems/Support/CastWhileChanneling.png?scale=1&w=1&h=1&v=2efa1f150e15467041775cd5eba6a2d03";
		boolean sixLink15 = false;
		String name15 = "";
		String typeLine15 = "Cast while Channelling Support";
		boolean corrupted15 = false;
		boolean identified15 = true;
		List<String> implicitMods15 = new ArrayList<String>();
		List<String> explicitMods15 = new ArrayList<String>();
		explicitMods15.add(new String("3% increased Damage"));
		explicitMods15.add(new String("You cannot Cast Supported Triggerable Spells directly"));
		explicitMods15.add(new String("Cast a Supported Spell every 0.45 seconds while Channelling Supported Skills"));
		int xLocation15 = -1;
		int yLocation15 = -1;
		List<PathOfExileItem> socketedItems15 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem15 = new PathOfExileItem(
			width15,
			height15,
			itemLevel15,
			icon15,
			sixLink15,
			name15,
			typeLine15,
			corrupted15,
			identified15,
			implicitMods15,
			explicitMods15,
			xLocation15,
			yLocation15,
			socketedItems15
		);
		socketedItems14.add(expectedItem15);
		int width16 = 1;
		int height16 = 1;
		int itemLevel16 = 0;
		String icon16 = "https://web.poecdn.com/image/Art/2DItems/Gems/FireNovaMineGem.png?scale=1&w=1&h=1&v=68cbcf04cd61ed4623d62638e8804d493";
		boolean sixLink16 = false;
		String name16 = "";
		String typeLine16 = "Fire Nova Mine";
		boolean corrupted16 = false;
		boolean identified16 = true;
		List<String> implicitMods16 = new ArrayList<String>();
		List<String> explicitMods16 = new ArrayList<String>();
		explicitMods16.add(new String("Deals 6 to 9 Fire Damage"));
		explicitMods16.add(new String("Mine lasts 16 seconds"));
		explicitMods16.add(new String("Spell Repeats 3 times"));
		explicitMods16.add(new String("5% increased Fire Damage"));
		explicitMods16.add(new String("20% more Damage per Repeat"));
		int xLocation16 = -1;
		int yLocation16 = -1;
		List<PathOfExileItem> socketedItems16 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem16 = new PathOfExileItem(
			width16,
			height16,
			itemLevel16,
			icon16,
			sixLink16,
			name16,
			typeLine16,
			corrupted16,
			identified16,
			implicitMods16,
			explicitMods16,
			xLocation16,
			yLocation16,
			socketedItems16
		);
		socketedItems14.add(expectedItem16);
		int width17 = 1;
		int height17 = 1;
		int itemLevel17 = 0;
		String icon17 = "https://web.poecdn.com/image/Art/2DItems/Gems/Support/LifeonHit.png?scale=1&w=1&h=1&v=1a15d95d5d29c1d1b92e3ad0193028a83";
		boolean sixLink17 = false;
		String name17 = "";
		String typeLine17 = "Life Gain on Hit Support";
		boolean corrupted17 = false;
		boolean identified17 = true;
		List<String> implicitMods17 = new ArrayList<String>();
		List<String> explicitMods17 = new ArrayList<String>();
		explicitMods17.add(new String("+12 Life gained for each enemy hit by Supported Attack"));
		int xLocation17 = -1;
		int yLocation17 = -1;
		List<PathOfExileItem> socketedItems17 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem17 = new PathOfExileItem(
			width17,
			height17,
			itemLevel17,
			icon17,
			sixLink17,
			name17,
			typeLine17,
			corrupted17,
			identified17,
			implicitMods17,
			explicitMods17,
			xLocation17,
			yLocation17,
			socketedItems17
		);
		socketedItems14.add(expectedItem17);
		int width18 = 1;
		int height18 = 1;
		int itemLevel18 = 0;
		String icon18 = "https://web.poecdn.com/image/Art/2DItems/Gems/ShockwaveTotem.png?scale=1&w=1&h=1&v=241110bff96e067e447f055ed2a13b8d3";
		boolean sixLink18 = false;
		String name18 = "";
		String typeLine18 = "Shockwave Totem";
		boolean corrupted18 = false;
		boolean identified18 = true;
		List<String> implicitMods18 = new ArrayList<String>();
		List<String> explicitMods18 = new ArrayList<String>();
		explicitMods18.add(new String("Deals 23 to 46 Physical Damage"));
		explicitMods18.add(new String("25% chance to Knock Enemies Back on hit"));
		explicitMods18.add(new String("Totem lasts 8 seconds"));
		explicitMods18.add(new String("Summons a Totem which uses this Skill"));
		explicitMods18.add(new String("5% increased totem life"));
		int xLocation18 = -1;
		int yLocation18 = -1;
		List<PathOfExileItem> socketedItems18 = new ArrayList<PathOfExileItem>();
		PathOfExileItem expectedItem18 = new PathOfExileItem(
			width18,
			height18,
			itemLevel18,
			icon18,
			sixLink18,
			name18,
			typeLine18,
			corrupted18,
			identified18,
			implicitMods18,
			explicitMods18,
			xLocation18,
			yLocation18,
			socketedItems18
		);
		socketedItems14.add(expectedItem18);
		PathOfExileItem expectedItem14 = new PathOfExileItem(
			width14,
			height14,
			itemLevel14,
			icon14,
			sixLink14,
			name14,
			typeLine14,
			corrupted14,
			identified14,
			implicitMods14,
			explicitMods14,
			xLocation14,
			yLocation14,
			socketedItems14
		);
		items.add(expectedItem14);
		return items;


	}
}
