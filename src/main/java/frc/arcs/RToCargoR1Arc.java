package frc.arcs;

import com.team319.follower.SrxMotionProfile;
import com.team319.follower.SrxTrajectory;

public class RToCargoR1Arc extends SrxTrajectory {
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (2.33,2.17,0.00)
	// (16.08,5.17,0.00)
	// (20.08,7.17,45.00)
	// (21.78,9.17,90.00)
	
    public RToCargoR1Arc() {
		super();
		this.highGear = true;
		centerProfile = new SrxMotionProfile(centerPoints.length, centerPoints);
	}

	
    public RToCargoR1Arc(boolean flipped) {
		super();
		this.highGear = true;
		this.flipped = flipped;
		centerProfile = new SrxMotionProfile(centerPoints.length, centerPoints);
	}

	public boolean highGear = true;

	double[][] centerPoints = {
				{0.000,0.000,10.000,0.000},
				{2.086,20.861,10.000,0.000},
				{6.258,41.722,10.000,0.000},
				{12.516,62.582,10.000,0.000},
				{20.861,83.443,10.000,0.000},
				{31.291,104.304,10.000,0.000},
				{43.808,125.165,10.000,0.000},
				{58.410,146.025,10.000,0.000},
				{75.099,166.886,10.000,0.000},
				{93.873,187.747,10.000,0.000},
				{114.734,208.608,10.000,0.000},
				{137.681,229.468,10.000,0.000},
				{162.714,250.329,10.000,-0.010},
				{189.833,271.190,10.000,-0.010},
				{219.038,292.051,10.000,-0.010},
				{250.329,312.911,10.000,-0.020},
				{283.706,333.772,10.000,-0.020},
				{319.170,354.633,10.000,-0.030},
				{356.719,375.494,10.000,-0.030},
				{396.354,396.354,10.000,-0.040},
				{438.076,417.215,10.000,-0.050},
				{481.883,438.076,10.000,-0.060},
				{527.777,458.937,10.000,-0.070},
				{575.757,479.797,10.000,-0.080},
				{625.823,500.658,10.000,-0.100},
				{677.975,521.519,10.000,-0.110},
				{732.213,542.380,10.000,-0.130},
				{788.537,563.240,10.000,-0.150},
				{846.947,584.101,10.000,-0.170},
				{907.443,604.962,10.000,-0.200},
				{970.025,625.823,10.000,-0.230},
				{1034.694,646.683,10.000,-0.260},
				{1101.448,667.544,10.000,-0.290},
				{1170.288,688.405,10.000,-0.330},
				{1241.215,709.266,10.000,-0.370},
				{1314.228,730.126,10.000,-0.410},
				{1389.326,750.987,10.000,-0.460},
				{1466.511,771.848,10.000,-0.510},
				{1545.782,792.709,10.000,-0.560},
				{1627.139,813.570,10.000,-0.620},
				{1710.582,834.430,10.000,-0.680},
				{1796.111,855.291,10.000,-0.750},
				{1883.726,876.152,10.000,-0.820},
				{1973.428,897.013,10.000,-0.890},
				{2065.215,917.873,10.000,-0.970},
				{2159.088,938.734,10.000,-1.060},
				{2255.048,959.595,10.000,-1.150},
				{2353.093,980.456,10.000,-1.240},
				{2453.225,1001.316,10.000,-1.340},
				{2555.443,1022.177,10.000,-1.450},
				{2659.746,1043.038,10.000,-1.560},
				{2766.136,1063.899,10.000,-1.680},
				{2874.612,1084.759,10.000,-1.810},
				{2985.174,1105.620,10.000,-1.940},
				{3097.822,1126.481,10.000,-2.080},
				{3212.557,1147.342,10.000,-2.220},
				{3329.377,1168.202,10.000,-2.370},
				{3448.283,1189.063,10.000,-2.530},
				{3569.275,1209.924,10.000,-2.690},
				{3692.354,1230.785,10.000,-2.860},
				{3817.518,1251.645,10.000,-3.040},
				{3944.769,1272.506,10.000,-3.220},
				{4074.106,1293.367,10.000,-3.410},
				{4205.529,1314.228,10.000,-3.610},
				{4339.037,1335.088,10.000,-3.820},
				{4474.632,1355.949,10.000,-4.030},
				{4612.313,1376.810,10.000,-4.250},
				{4752.080,1397.671,10.000,-4.480},
				{4893.934,1418.531,10.000,-4.710},
				{5037.873,1439.392,10.000,-4.960},
				{5183.898,1460.253,10.000,-5.210},
				{5332.009,1481.114,10.000,-5.460},
				{5482.207,1501.974,10.000,-5.730},
				{5634.490,1522.835,10.000,-6.000},
				{5788.860,1543.696,10.000,-6.280},
				{5945.316,1564.557,10.000,-6.570},
				{6103.857,1585.418,10.000,-6.860},
				{6264.485,1606.278,10.000,-7.160},
				{6427.199,1627.139,10.000,-7.460},
				{6591.999,1648.000,10.000,-7.780},
				{6758.885,1668.861,10.000,-8.100},
				{6927.857,1689.721,10.000,-8.420},
				{7098.916,1710.582,10.000,-8.750},
				{7272.060,1731.443,10.000,-9.090},
				{7447.290,1752.304,10.000,-9.430},
				{7624.607,1773.164,10.000,-9.780},
				{7804.009,1794.025,10.000,-10.130},
				{7985.498,1814.886,10.000,-10.490},
				{8169.072,1835.747,10.000,-10.850},
				{8354.733,1856.607,10.000,-11.210},
				{8542.480,1877.468,10.000,-11.580},
				{8732.313,1898.329,10.000,-11.950},
				{8924.232,1919.190,10.000,-12.320},
				{9118.237,1940.050,10.000,-12.700},
				{9314.328,1960.911,10.000,-13.070},
				{9512.505,1981.772,10.000,-13.450},
				{9712.768,2002.633,10.000,-13.830},
				{9915.118,2023.493,10.000,-14.210},
				{10119.553,2044.354,10.000,-14.580},
				{10326.075,2065.215,10.000,-14.960},
				{10534.682,2086.076,10.000,-15.340},
				{10745.376,2106.936,10.000,-15.710},
				{10958.155,2127.797,10.000,-16.080},
				{11173.021,2148.658,10.000,-16.450},
				{11389.973,2169.519,10.000,-16.810},
				{11609.011,2190.379,10.000,-17.170},
				{11830.135,2211.240,10.000,-17.530},
				{12053.345,2232.101,10.000,-17.870},
				{12278.641,2252.962,10.000,-18.220},
				{12506.024,2273.822,10.000,-18.550},
				{12735.492,2294.683,10.000,-18.880},
				{12967.046,2315.544,10.000,-19.200},
				{13200.687,2336.405,10.000,-19.520},
				{13436.413,2357.266,10.000,-19.820},
				{13674.226,2378.126,10.000,-20.110},
				{13914.125,2398.987,10.000,-20.400},
				{14156.109,2419.848,10.000,-20.670},
				{14400.180,2440.709,10.000,-20.930},
				{14646.337,2461.569,10.000,-21.180},
				{14894.580,2482.430,10.000,-21.420},
				{15144.909,2503.291,10.000,-21.640},
				{15397.325,2524.152,10.000,-21.850},
				{15651.826,2545.012,10.000,-22.050},
				{15908.413,2565.873,10.000,-22.230},
				{16167.086,2586.734,10.000,-22.390},
				{16427.846,2607.595,10.000,-22.540},
				{16690.691,2628.455,10.000,-22.680},
				{16955.623,2649.316,10.000,-22.790},
				{17222.641,2670.177,10.000,-22.890},
				{17491.744,2691.038,10.000,-22.980},
				{17762.934,2711.898,10.000,-23.040},
				{18036.210,2732.759,10.000,-23.080},
				{18311.572,2753.620,10.000,-23.110},
				{18589.020,2774.481,10.000,-23.120},
				{18868.554,2795.341,10.000,-23.100},
				{19150.175,2816.202,10.000,-23.070},
				{19433.881,2837.063,10.000,-23.010},
				{19719.673,2857.924,10.000,-22.930},
				{20007.552,2878.784,10.000,-22.840},
				{20297.516,2899.645,10.000,-22.710},
				{20589.567,2920.506,10.000,-22.570},
				{20883.704,2941.367,10.000,-22.400},
				{21179.926,2962.227,10.000,-22.210},
				{21478.235,2983.088,10.000,-22.000},
				{21778.630,3003.949,10.000,-21.760},
				{22081.111,3024.810,10.000,-21.500},
				{22385.678,3045.670,10.000,-21.220},
				{22692.331,3066.531,10.000,-20.910},
				{23001.070,3087.392,10.000,-20.570},
				{23311.640,3105.692,10.000,-20.210},
				{23622.209,3105.692,10.000,-19.830},
				{23932.778,3105.692,10.000,-19.430},
				{24243.347,3105.692,10.000,-19.010},
				{24553.916,3105.692,10.000,-18.570},
				{24864.485,3105.692,10.000,-18.110},
				{25175.055,3105.692,10.000,-17.630},
				{25485.624,3105.692,10.000,-17.130},
				{25796.193,3105.692,10.000,-16.620},
				{26106.762,3105.692,10.000,-16.090},
				{26417.331,3105.692,10.000,-15.540},
				{26727.901,3105.692,10.000,-14.990},
				{27038.470,3105.692,10.000,-14.420},
				{27349.039,3105.692,10.000,-13.840},
				{27659.608,3105.692,10.000,-13.250},
				{27970.177,3105.692,10.000,-12.660},
				{28280.746,3105.692,10.000,-12.060},
				{28591.316,3105.692,10.000,-11.450},
				{28901.885,3105.692,10.000,-10.840},
				{29212.454,3105.692,10.000,-10.230},
				{29523.023,3105.692,10.000,-9.620},
				{29833.592,3105.692,10.000,-9.020},
				{30144.162,3105.692,10.000,-8.420},
				{30454.731,3105.692,10.000,-7.820},
				{30765.300,3105.692,10.000,-7.230},
				{31075.869,3105.692,10.000,-6.650},
				{31386.438,3105.692,10.000,-6.090},
				{31697.007,3105.692,10.000,-5.530},
				{32007.577,3105.692,10.000,-5.000},
				{32318.146,3105.692,10.000,-4.480},
				{32628.715,3105.692,10.000,-3.980},
				{32939.284,3105.692,10.000,-3.500},
				{33249.853,3105.692,10.000,-3.040},
				{33560.423,3105.692,10.000,-2.610},
				{33870.992,3105.692,10.000,-2.200},
				{34181.561,3105.692,10.000,-1.820},
				{34492.130,3105.692,10.000,-1.470},
				{34802.699,3105.692,10.000,-1.160},
				{35113.268,3105.692,10.000,-0.880},
				{35423.838,3105.692,10.000,-0.630},
				{35734.407,3105.692,10.000,-0.420},
				{36044.976,3105.692,10.000,-0.250},
				{36355.545,3105.692,10.000,-0.120},
				{36666.114,3105.692,10.000,-0.040},
				{36976.683,3105.692,10.000,0.000},
				{37287.253,3105.692,10.000,-0.060},
				{37597.822,3105.692,10.000,-0.360},
				{37908.391,3105.692,10.000,-0.880},
				{38218.960,3105.692,10.000,-1.620},
				{38218.960,3105.692,10.000,-1.620},
				{38527.443,3084.831,10.000,-2.540},
				{38833.840,3063.970,10.000,-3.650},
				{39138.151,3043.110,10.000,-4.930},
				{39440.376,3022.249,10.000,-6.360},
				{39740.515,3001.388,10.000,-7.930},
				{40038.568,2980.527,10.000,-9.630},
				{40334.534,2959.667,10.000,-11.430},
				{40628.415,2938.806,10.000,-13.320},
				{40920.209,2917.945,10.000,-15.280},
				{41209.918,2897.084,10.000,-17.290},
				{41497.540,2876.223,10.000,-19.320},
				{41783.076,2855.363,10.000,-21.340},
				{42066.527,2834.502,10.000,-23.340},
				{42347.891,2813.641,10.000,-25.300},
				{42627.169,2792.780,10.000,-27.190},
				{42904.361,2771.920,10.000,-29.000},
				{43179.467,2751.059,10.000,-30.720},
				{43452.487,2730.198,10.000,-32.340},
				{43723.420,2709.337,10.000,-33.850},
				{43992.268,2688.477,10.000,-35.250},
				{44259.030,2667.616,10.000,-36.540},
				{44523.705,2646.755,10.000,-37.710},
				{44786.295,2625.894,10.000,-38.780},
				{45046.798,2605.034,10.000,-39.740},
				{45305.215,2584.173,10.000,-40.590},
				{45561.546,2563.312,10.000,-41.350},
				{45815.792,2542.451,10.000,-42.020},
				{46067.951,2521.591,10.000,-42.600},
				{46318.024,2500.730,10.000,-43.100},
				{46566.010,2479.869,10.000,-43.520},
				{46811.911,2459.008,10.000,-43.880},
				{47055.726,2438.148,10.000,-44.180},
				{47297.455,2417.287,10.000,-44.410},
				{47537.097,2396.426,10.000,-44.600},
				{47774.654,2375.565,10.000,-44.740},
				{48010.124,2354.705,10.000,-44.850},
				{48243.509,2333.844,10.000,-44.920},
				{48474.807,2312.983,10.000,-44.960},
				{48704.019,2292.122,10.000,-44.990},
				{48931.145,2271.262,10.000,-45.000},
				{49156.186,2250.401,10.000,-45.000},
				{49379.140,2229.540,10.000,-44.760},
				{49600.007,2208.679,10.000,-43.700},
				{49818.789,2187.819,10.000,-42.030},
				{50035.485,2166.958,10.000,-39.990},
				{50250.095,2146.097,10.000,-37.760},
				{50462.618,2125.236,10.000,-35.530},
				{50673.056,2104.375,10.000,-33.420},
				{50881.407,2083.515,10.000,-31.530},
				{51087.673,2062.654,10.000,-29.920},
				{51291.852,2041.793,10.000,-28.630},
				{51493.945,2020.932,10.000,-27.680},
				{51693.953,2000.072,10.000,-27.080},
				{51891.874,1979.211,10.000,-26.850},
				{52087.709,1958.350,10.000,-26.990},
				{52281.458,1937.489,10.000,-27.500},
				{52473.120,1916.629,10.000,-28.410},
				{52473.120,1916.629,10.000,-28.410},
				{52662.697,1895.768,10.000,-29.720},
				{52850.188,1874.907,10.000,-31.460},
				{53035.593,1854.046,10.000,-33.640},
				{53218.911,1833.186,10.000,-36.280},
				{53400.144,1812.325,10.000,-39.350},
				{53579.290,1791.464,10.000,-42.850},
				{53756.350,1770.603,10.000,-46.720},
				{53931.325,1749.743,10.000,-50.860},
				{54104.213,1728.882,10.000,-55.150},
				{54275.015,1708.021,10.000,-59.470},
				{54443.731,1687.160,10.000,-63.660},
				{54610.361,1666.300,10.000,-67.630},
				{54774.905,1645.439,10.000,-71.290},
				{54937.363,1624.578,10.000,-74.600},
				{55097.734,1603.717,10.000,-77.530},
				{55256.020,1582.857,10.000,-80.090},
				{55412.220,1561.996,10.000,-82.310},
				{55566.333,1541.135,10.000,-84.190},
				{55718.361,1520.274,10.000,-85.780},
				{55868.302,1499.414,10.000,-87.080},
				{56016.157,1478.553,10.000,-88.130},
				{56161.926,1457.692,10.000,-88.940},
				{56305.610,1436.831,10.000,-89.510},
				{56447.207,1415.971,10.000,-89.870},
				{56586.718,1395.110,10.000,-90.000},
				{56724.142,1374.249,10.000,-90.000},
				{56859.481,1353.388,10.000,-90.000},
				{56992.734,1332.527,10.000,-90.000},
				{57123.901,1311.667,10.000,-90.000},
				{57252.981,1290.806,10.000,-90.000},
				{57379.976,1269.945,10.000,-90.000},
				{57504.884,1249.084,10.000,-90.000},
				{57627.707,1228.224,10.000,-90.000},
				{57748.443,1207.363,10.000,-90.000},
				{57867.093,1186.502,10.000,-90.000},
				{57983.657,1165.641,10.000,-90.000},
				{58098.135,1144.781,10.000,-90.000},
				{58210.527,1123.920,10.000,-90.000},
				{58320.833,1103.059,10.000,-90.000},
				{58429.053,1082.198,10.000,-90.000},
				{58535.187,1061.338,10.000,-90.000},
				{58639.235,1040.477,10.000,-90.000},
				{58741.196,1019.616,10.000,-90.000},
				{58841.072,998.755,10.000,-90.000},
				{58938.861,977.895,10.000,-90.000},
				{59034.565,957.034,10.000,-90.000},
				{59128.182,936.173,10.000,-90.000},
				{59219.713,915.312,10.000,-90.000},
				{59309.158,894.452,10.000,-90.000},
				{59396.517,873.591,10.000,-90.000},
				{59481.790,852.730,10.000,-90.000},
				{59564.977,831.869,10.000,-90.000},
				{59646.078,811.009,10.000,-90.000},
				{59725.093,790.148,10.000,-90.000},
				{59802.022,769.287,10.000,-90.000},
				{59876.864,748.426,10.000,-90.000},
				{59949.621,727.566,10.000,-90.000},
				{60020.291,706.705,10.000,-90.000},
				{60088.876,685.844,10.000,-90.000},
				{60155.374,664.983,10.000,-90.000},
				{60219.786,644.123,10.000,-90.000},
				{60282.113,623.262,10.000,-90.000},
				{60342.353,602.401,10.000,-90.000},
				{60400.507,581.540,10.000,-90.000},
				{60456.575,560.679,10.000,-90.000},
				{60510.556,539.819,10.000,-90.000},
				{60562.452,518.958,10.000,-90.000},
				{60612.262,498.097,10.000,-90.000},
				{60659.986,477.236,10.000,-90.000},
				{60705.623,456.376,10.000,-90.000},
				{60749.175,435.515,10.000,-90.000},
				{60790.640,414.654,10.000,-90.000},
				{60830.019,393.793,10.000,-90.000},
				{60867.313,372.933,10.000,-90.000},
				{60902.520,352.072,10.000,-90.000},
				{60935.641,331.211,10.000,-90.000},
				{60966.676,310.350,10.000,-90.000},
				{60995.625,289.490,10.000,-90.000},
				{61022.488,268.629,10.000,-90.000},
				{61047.265,247.768,10.000,-90.000}		};

}