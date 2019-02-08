package frc.arcs;

import com.team319.follower.SrxMotionProfile;
import com.team319.follower.SrxTrajectory;

public class SpeedTestingArc extends SrxTrajectory {
	
	// WAYPOINTS:
	// (X,Y,degrees)
	// (2.00,13.50,0.00)
	// (5.00,16.50,89.99)
	// (2.00,19.50,179.98)
	
    public SpeedTestingArc() {
		super();
		this.highGear = true;
		centerProfile = new SrxMotionProfile(centerPoints.length, centerPoints);
	}

	
    public SpeedTestingArc(boolean flipped) {
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
				{93.873,187.747,10.000,-0.010},
				{114.734,208.608,10.000,-0.010},
				{137.681,229.468,10.000,-0.010},
				{162.714,250.329,10.000,-0.020},
				{189.833,271.190,10.000,-0.030},
				{219.038,292.051,10.000,-0.030},
				{250.329,312.911,10.000,-0.040},
				{283.706,333.772,10.000,-0.060},
				{319.170,354.633,10.000,-0.070},
				{356.719,375.494,10.000,-0.090},
				{396.354,396.354,10.000,-0.110},
				{438.076,417.215,10.000,-0.130},
				{481.883,438.076,10.000,-0.160},
				{527.777,458.937,10.000,-0.190},
				{575.757,479.797,10.000,-0.230},
				{625.823,500.658,10.000,-0.270},
				{677.975,521.519,10.000,-0.320},
				{732.213,542.380,10.000,-0.370},
				{788.537,563.240,10.000,-0.430},
				{846.947,584.101,10.000,-0.490},
				{907.443,604.962,10.000,-0.570},
				{970.025,625.823,10.000,-0.650},
				{1034.694,646.683,10.000,-0.730},
				{1101.448,667.544,10.000,-0.830},
				{1170.288,688.405,10.000,-0.940},
				{1241.215,709.266,10.000,-1.060},
				{1314.228,730.126,10.000,-1.180},
				{1389.326,750.987,10.000,-1.320},
				{1466.511,771.848,10.000,-1.480},
				{1544.739,782.278,10.000,-1.640},
				{1622.967,782.278,10.000,-1.810},
				{1701.195,782.278,10.000,-1.990},
				{1779.423,782.278,10.000,-2.180},
				{1857.650,782.278,10.000,-2.390},
				{1935.878,782.278,10.000,-2.600},
				{2014.106,782.278,10.000,-2.820},
				{2092.334,782.278,10.000,-3.050},
				{2170.562,782.278,10.000,-3.290},
				{2248.790,782.278,10.000,-3.540},
				{2327.017,782.278,10.000,-3.800},
				{2405.245,782.278,10.000,-4.070},
				{2483.473,782.278,10.000,-4.350},
				{2561.701,782.278,10.000,-4.650},
				{2639.929,782.278,10.000,-4.960},
				{2718.157,782.278,10.000,-5.270},
				{2796.384,782.278,10.000,-5.610},
				{2874.612,782.278,10.000,-5.950},
				{2952.840,782.278,10.000,-6.310},
				{3031.068,782.278,10.000,-6.680},
				{3109.296,782.278,10.000,-7.060},
				{3187.524,782.278,10.000,-7.460},
				{3265.751,782.278,10.000,-7.870},
				{3343.979,782.278,10.000,-8.300},
				{3422.207,782.278,10.000,-8.740},
				{3500.435,782.278,10.000,-9.200},
				{3578.663,782.278,10.000,-9.670},
				{3656.891,782.278,10.000,-10.160},
				{3735.118,782.278,10.000,-10.670},
				{3813.346,782.278,10.000,-11.190},
				{3891.574,782.278,10.000,-11.740},
				{3969.802,782.278,10.000,-12.300},
				{4048.030,782.278,10.000,-12.880},
				{4126.258,782.278,10.000,-13.480},
				{4204.486,782.278,10.000,-14.100},
				{4282.713,782.278,10.000,-14.740},
				{4360.941,782.278,10.000,-15.400},
				{4439.169,782.278,10.000,-16.080},
				{4517.397,782.278,10.000,-16.780},
				{4595.625,782.278,10.000,-17.510},
				{4673.853,782.278,10.000,-18.260},
				{4752.080,782.278,10.000,-19.030},
				{4830.308,782.278,10.000,-19.820},
				{4908.536,782.278,10.000,-20.640},
				{4986.764,782.278,10.000,-21.480},
				{5064.992,782.278,10.000,-22.340},
				{5143.220,782.278,10.000,-23.230},
				{5221.447,782.278,10.000,-24.150},
				{5299.675,782.278,10.000,-25.080},
				{5377.903,782.278,10.000,-26.040},
				{5456.131,782.278,10.000,-27.030},
				{5534.359,782.278,10.000,-28.040},
				{5612.587,782.278,10.000,-29.060},
				{5690.814,782.278,10.000,-30.120},
				{5769.042,782.278,10.000,-31.190},
				{5847.270,782.278,10.000,-32.280},
				{5925.498,782.278,10.000,-33.390},
				{6003.726,782.278,10.000,-34.520},
				{6081.954,782.278,10.000,-35.670},
				{6160.181,782.278,10.000,-36.830},
				{6238.409,782.278,10.000,-38.000},
				{6316.637,782.278,10.000,-39.190},
				{6394.865,782.278,10.000,-40.380},
				{6473.093,782.278,10.000,-41.590},
				{6551.321,782.278,10.000,-42.800},
				{6629.548,782.278,10.000,-44.010},
				{6707.776,782.278,10.000,-45.220},
				{6786.004,782.278,10.000,-46.440},
				{6864.232,782.278,10.000,-47.650},
				{6942.460,782.278,10.000,-48.860},
				{7020.688,782.278,10.000,-50.060},
				{7098.916,782.278,10.000,-51.250},
				{7177.143,782.278,10.000,-52.430},
				{7255.371,782.278,10.000,-53.600},
				{7333.599,782.278,10.000,-54.760},
				{7411.827,782.278,10.000,-55.900},
				{7490.055,782.278,10.000,-57.020},
				{7568.283,782.278,10.000,-58.120},
				{7646.510,782.278,10.000,-59.210},
				{7724.738,782.278,10.000,-60.270},
				{7802.966,782.278,10.000,-61.320},
				{7881.194,782.278,10.000,-62.340},
				{7959.422,782.278,10.000,-63.340},
				{8037.650,782.278,10.000,-64.310},
				{8115.877,782.278,10.000,-65.260},
				{8194.105,782.278,10.000,-66.190},
				{8272.333,782.278,10.000,-67.090},
				{8350.561,782.278,10.000,-67.970},
				{8428.789,782.278,10.000,-68.830},
				{8507.017,782.278,10.000,-69.660},
				{8585.244,782.278,10.000,-70.470},
				{8663.472,782.278,10.000,-71.260},
				{8741.700,782.278,10.000,-72.020},
				{8819.928,782.278,10.000,-72.760},
				{8898.156,782.278,10.000,-73.470},
				{8976.384,782.278,10.000,-74.170},
				{9054.611,782.278,10.000,-74.840},
				{9132.839,782.278,10.000,-75.500},
				{9211.067,782.278,10.000,-76.130},
				{9289.295,782.278,10.000,-76.740},
				{9367.523,782.278,10.000,-77.330},
				{9445.751,782.278,10.000,-77.900},
				{9523.978,782.278,10.000,-78.460},
				{9602.206,782.278,10.000,-79.000},
				{9680.434,782.278,10.000,-79.510},
				{9758.662,782.278,10.000,-80.010},
				{9836.890,782.278,10.000,-80.500},
				{9915.118,782.278,10.000,-80.970},
				{9993.345,782.278,10.000,-81.420},
				{10071.573,782.278,10.000,-81.850},
				{10149.801,782.278,10.000,-82.280},
				{10228.029,782.278,10.000,-82.680},
				{10306.257,782.278,10.000,-83.070},
				{10384.485,782.278,10.000,-83.450},
				{10462.713,782.278,10.000,-83.820},
				{10540.940,782.278,10.000,-84.170},
				{10619.168,782.278,10.000,-84.510},
				{10697.396,782.278,10.000,-84.840},
				{10775.624,782.278,10.000,-85.150},
				{10853.852,782.278,10.000,-85.450},
				{10932.080,782.278,10.000,-85.740},
				{11010.307,782.278,10.000,-86.020},
				{11088.535,782.278,10.000,-86.290},
				{11166.763,782.278,10.000,-86.550},
				{11244.991,782.278,10.000,-86.790},
				{11323.219,782.278,10.000,-87.030},
				{11401.447,782.278,10.000,-87.260},
				{11479.674,782.278,10.000,-87.470},
				{11557.902,782.278,10.000,-87.680},
				{11636.130,782.278,10.000,-87.880},
				{11714.358,782.278,10.000,-88.060},
				{11792.586,782.278,10.000,-88.240},
				{11870.814,782.278,10.000,-88.410},
				{11949.041,782.278,10.000,-88.570},
				{12027.269,782.278,10.000,-88.720},
				{12105.497,782.278,10.000,-88.860},
				{12183.725,782.278,10.000,-89.000},
				{12259.867,761.418,10.000,-89.120},
				{12333.922,740.557,10.000,-89.230},
				{12405.892,719.696,10.000,-89.330},
				{12475.776,698.835,10.000,-89.420},
				{12543.573,677.975,10.000,-89.500},
				{12609.284,657.114,10.000,-89.570},
				{12672.910,636.253,10.000,-89.640},
				{12734.449,615.392,10.000,-89.700},
				{12793.902,594.532,10.000,-89.750},
				{12851.269,573.671,10.000,-89.790},
				{12906.550,552.810,10.000,-89.830},
				{12959.745,531.949,10.000,-89.860},
				{13010.854,511.089,10.000,-89.890},
				{13059.877,490.228,10.000,-89.920},
				{13106.813,469.367,10.000,-89.940},
				{13151.664,448.506,10.000,-89.950},
				{13194.429,427.646,10.000,-89.960},
				{13235.107,406.785,10.000,-89.970},
				{13273.699,385.924,10.000,-89.980},
				{13310.206,365.063,10.000,-89.990},
				{13344.626,344.202,10.000,-89.990},
				{13376.960,323.342,10.000,-89.990},
				{13407.208,302.481,10.000,-89.990},
				{13407.208,302.481,10.000,-89.990},
				{13433.284,260.759,10.000,-89.990},
				{13459.360,260.759,10.000,-89.990},
				{13485.436,260.759,10.000,-90.000},
				{13511.512,260.759,10.000,-90.000},
				{13537.588,260.759,10.000,-90.010},
				{13563.664,260.759,10.000,-90.010},
				{13589.740,260.759,10.000,-90.020},
				{13615.816,260.759,10.000,-90.030},
				{13641.892,260.759,10.000,-90.040},
				{13667.968,260.759,10.000,-90.040},
				{13694.044,260.759,10.000,-90.060},
				{13720.120,260.759,10.000,-90.070},
				{13746.196,260.759,10.000,-90.080},
				{13772.272,260.759,10.000,-90.090},
				{13798.348,260.759,10.000,-90.110},
				{13824.423,260.759,10.000,-90.120},
				{13850.499,260.759,10.000,-90.140},
				{13876.575,260.759,10.000,-90.160},
				{13902.651,260.759,10.000,-90.170},
				{13928.727,260.759,10.000,-90.190},
				{13954.803,260.759,10.000,-90.210},
				{13980.879,260.759,10.000,-90.230},
				{14006.955,260.759,10.000,-90.250},
				{14033.031,260.759,10.000,-90.280},
				{14059.107,260.759,10.000,-90.300},
				{14085.183,260.759,10.000,-90.330},
				{14111.259,260.759,10.000,-90.350},
				{14137.335,260.759,10.000,-90.380},
				{14163.411,260.759,10.000,-90.400},
				{14189.487,260.759,10.000,-90.430},
				{14215.563,260.759,10.000,-90.460},
				{14241.639,260.759,10.000,-90.490},
				{14267.715,260.759,10.000,-90.520},
				{14293.790,260.759,10.000,-90.550},
				{14319.866,260.759,10.000,-90.590},
				{14345.942,260.759,10.000,-90.620},
				{14372.018,260.759,10.000,-90.660},
				{14398.094,260.759,10.000,-90.690},
				{14424.170,260.759,10.000,-90.730},
				{14450.246,260.759,10.000,-90.770},
				{14476.322,260.759,10.000,-90.800},
				{14502.398,260.759,10.000,-90.840},
				{14528.474,260.759,10.000,-90.880},
				{14554.550,260.759,10.000,-90.920},
				{14580.626,260.759,10.000,-90.970},
				{14606.702,260.759,10.000,-91.010},
				{14632.778,260.759,10.000,-91.050},
				{14658.854,260.759,10.000,-91.100},
				{14684.930,260.759,10.000,-91.150},
				{14711.006,260.759,10.000,-91.190},
				{14737.082,260.759,10.000,-91.240},
				{14763.158,260.759,10.000,-91.290},
				{14789.233,260.759,10.000,-91.340},
				{14815.309,260.759,10.000,-91.390},
				{14841.385,260.759,10.000,-91.440},
				{14867.461,260.759,10.000,-91.500},
				{14893.537,260.759,10.000,-91.550},
				{14919.613,260.759,10.000,-91.600},
				{14945.689,260.759,10.000,-91.660},
				{14971.765,260.759,10.000,-91.720},
				{14997.841,260.759,10.000,-91.780},
				{15023.917,260.759,10.000,-91.830},
				{15049.993,260.759,10.000,-91.890},
				{15076.069,260.759,10.000,-91.960},
				{15102.145,260.759,10.000,-92.020},
				{15128.221,260.759,10.000,-92.080},
				{15154.297,260.759,10.000,-92.150},
				{15180.373,260.759,10.000,-92.210},
				{15206.449,260.759,10.000,-92.280},
				{15232.525,260.759,10.000,-92.340},
				{15258.600,260.759,10.000,-92.410},
				{15284.676,260.759,10.000,-92.480},
				{15310.752,260.759,10.000,-92.550},
				{15336.828,260.759,10.000,-92.620},
				{15362.904,260.759,10.000,-92.700},
				{15388.980,260.759,10.000,-92.770},
				{15415.056,260.759,10.000,-92.850},
				{15441.132,260.759,10.000,-92.920},
				{15467.208,260.759,10.000,-93.000},
				{15493.284,260.759,10.000,-93.080},
				{15519.360,260.759,10.000,-93.160},
				{15545.436,260.759,10.000,-93.240},
				{15571.512,260.759,10.000,-93.320},
				{15597.588,260.759,10.000,-93.400},
				{15623.664,260.759,10.000,-93.490},
				{15649.740,260.759,10.000,-93.570},
				{15675.816,260.759,10.000,-93.660},
				{15701.892,260.759,10.000,-93.750},
				{15727.968,260.759,10.000,-93.840},
				{15754.043,260.759,10.000,-93.930},
				{15780.119,260.759,10.000,-94.020},
				{15806.195,260.759,10.000,-94.110},
				{15832.271,260.759,10.000,-94.210},
				{15858.347,260.759,10.000,-94.300},
				{15884.423,260.759,10.000,-94.400},
				{15910.499,260.759,10.000,-94.500},
				{15936.575,260.759,10.000,-94.590},
				{15962.651,260.759,10.000,-94.690},
				{15988.727,260.759,10.000,-94.800},
				{16014.803,260.759,10.000,-94.900},
				{16040.879,260.759,10.000,-95.000},
				{16066.955,260.759,10.000,-95.110},
				{16093.031,260.759,10.000,-95.220},
				{16119.107,260.759,10.000,-95.320},
				{16145.183,260.759,10.000,-95.430},
				{16171.259,260.759,10.000,-95.550},
				{16197.335,260.759,10.000,-95.660},
				{16223.410,260.759,10.000,-95.770},
				{16249.486,260.759,10.000,-95.890},
				{16275.562,260.759,10.000,-96.000},
				{16301.638,260.759,10.000,-96.120},
				{16327.714,260.759,10.000,-96.240},
				{16353.790,260.759,10.000,-96.360},
				{16379.866,260.759,10.000,-96.490},
				{16405.942,260.759,10.000,-96.610},
				{16432.018,260.759,10.000,-96.740},
				{16458.094,260.759,10.000,-96.860},
				{16484.170,260.759,10.000,-96.990},
				{16510.246,260.759,10.000,-97.120},
				{16536.322,260.759,10.000,-97.250},
				{16562.398,260.759,10.000,-97.390},
				{16588.474,260.759,10.000,-97.520},
				{16614.550,260.759,10.000,-97.660},
				{16640.626,260.759,10.000,-97.800},
				{16666.702,260.759,10.000,-97.940},
				{16692.778,260.759,10.000,-98.080},
				{16718.853,260.759,10.000,-98.220},
				{16744.929,260.759,10.000,-98.370},
				{16771.005,260.759,10.000,-98.510},
				{16797.081,260.759,10.000,-98.660},
				{16823.157,260.759,10.000,-98.810},
				{16849.233,260.759,10.000,-98.970},
				{16875.309,260.759,10.000,-99.120},
				{16901.385,260.759,10.000,-99.270},
				{16927.461,260.759,10.000,-99.430},
				{16953.537,260.759,10.000,-99.590},
				{16979.613,260.759,10.000,-99.750},
				{17005.689,260.759,10.000,-99.910},
				{17031.765,260.759,10.000,-100.080},
				{17057.841,260.759,10.000,-100.250},
				{17083.917,260.759,10.000,-100.410},
				{17109.993,260.759,10.000,-100.580},
				{17136.069,260.759,10.000,-100.760},
				{17162.145,260.759,10.000,-100.930},
				{17188.220,260.759,10.000,-101.110},
				{17214.296,260.759,10.000,-101.280},
				{17240.372,260.759,10.000,-101.460},
				{17266.448,260.759,10.000,-101.650},
				{17292.524,260.759,10.000,-101.830},
				{17318.600,260.759,10.000,-102.020},
				{17344.676,260.759,10.000,-102.210},
				{17370.752,260.759,10.000,-102.400},
				{17396.828,260.759,10.000,-102.590},
				{17422.904,260.759,10.000,-102.780},
				{17448.980,260.759,10.000,-102.980},
				{17475.056,260.759,10.000,-103.180},
				{17501.132,260.759,10.000,-103.380},
				{17527.208,260.759,10.000,-103.580},
				{17553.284,260.759,10.000,-103.790},
				{17579.360,260.759,10.000,-104.000},
				{17605.436,260.759,10.000,-104.210},
				{17631.512,260.759,10.000,-104.420},
				{17657.588,260.759,10.000,-104.630},
				{17683.663,260.759,10.000,-104.850},
				{17709.739,260.759,10.000,-105.070},
				{17735.815,260.759,10.000,-105.290},
				{17761.891,260.759,10.000,-105.510},
				{17787.967,260.759,10.000,-105.740},
				{17814.043,260.759,10.000,-105.970},
				{17840.119,260.759,10.000,-106.200},
				{17866.195,260.759,10.000,-106.430},
				{17892.271,260.759,10.000,-106.670},
				{17918.347,260.759,10.000,-106.910},
				{17944.423,260.759,10.000,-107.150},
				{17970.499,260.759,10.000,-107.390},
				{17996.575,260.759,10.000,-107.640},
				{18022.651,260.759,10.000,-107.890},
				{18048.727,260.759,10.000,-108.140},
				{18074.803,260.759,10.000,-108.390},
				{18100.879,260.759,10.000,-108.650},
				{18126.955,260.759,10.000,-108.900},
				{18153.030,260.759,10.000,-109.170},
				{18179.106,260.759,10.000,-109.430},
				{18205.182,260.759,10.000,-109.700},
				{18231.258,260.759,10.000,-109.960},
				{18257.334,260.759,10.000,-110.240},
				{18283.410,260.759,10.000,-110.510},
				{18309.486,260.759,10.000,-110.790},
				{18335.562,260.759,10.000,-111.070},
				{18361.638,260.759,10.000,-111.350},
				{18387.714,260.759,10.000,-111.630},
				{18413.790,260.759,10.000,-111.920},
				{18439.866,260.759,10.000,-112.210},
				{18465.942,260.759,10.000,-112.500},
				{18492.018,260.759,10.000,-112.800},
				{18518.094,260.759,10.000,-113.100},
				{18544.170,260.759,10.000,-113.400},
				{18570.246,260.759,10.000,-113.700},
				{18596.322,260.759,10.000,-114.010},
				{18622.398,260.759,10.000,-114.310},
				{18648.473,260.759,10.000,-114.620},
				{18674.549,260.759,10.000,-114.940},
				{18700.625,260.759,10.000,-115.260},
				{18726.701,260.759,10.000,-115.570},
				{18752.777,260.759,10.000,-115.900},
				{18778.853,260.759,10.000,-116.220},
				{18804.929,260.759,10.000,-116.550},
				{18831.005,260.759,10.000,-116.880},
				{18857.081,260.759,10.000,-117.210},
				{18883.157,260.759,10.000,-117.540},
				{18909.233,260.759,10.000,-117.880},
				{18935.309,260.759,10.000,-118.220},
				{18961.385,260.759,10.000,-118.560},
				{18987.461,260.759,10.000,-118.910},
				{19013.537,260.759,10.000,-119.250},
				{19039.613,260.759,10.000,-119.600},
				{19065.689,260.759,10.000,-119.950},
				{19091.765,260.759,10.000,-120.310},
				{19117.840,260.759,10.000,-120.670},
				{19143.916,260.759,10.000,-121.020},
				{19169.992,260.759,10.000,-121.390},
				{19196.068,260.759,10.000,-121.750},
				{19222.144,260.759,10.000,-122.110},
				{19248.220,260.759,10.000,-122.480},
				{19274.296,260.759,10.000,-122.850},
				{19300.372,260.759,10.000,-123.220},
				{19326.448,260.759,10.000,-123.600},
				{19352.524,260.759,10.000,-123.970},
				{19378.600,260.759,10.000,-124.350},
				{19404.676,260.759,10.000,-124.730},
				{19430.752,260.759,10.000,-125.110},
				{19456.828,260.759,10.000,-125.490},
				{19482.904,260.759,10.000,-125.880},
				{19508.980,260.759,10.000,-126.260},
				{19535.056,260.759,10.000,-126.650},
				{19561.132,260.759,10.000,-127.040},
				{19587.208,260.759,10.000,-127.430},
				{19613.283,260.759,10.000,-127.820},
				{19639.359,260.759,10.000,-128.220},
				{19665.435,260.759,10.000,-128.610},
				{19691.511,260.759,10.000,-129.010},
				{19717.587,260.759,10.000,-129.410},
				{19743.663,260.759,10.000,-129.800},
				{19769.739,260.759,10.000,-130.200},
				{19795.815,260.759,10.000,-130.600},
				{19821.891,260.759,10.000,-131.000},
				{19847.967,260.759,10.000,-131.410},
				{19874.043,260.759,10.000,-131.810},
				{19900.119,260.759,10.000,-132.210},
				{19926.195,260.759,10.000,-132.610},
				{19952.271,260.759,10.000,-133.020},
				{19978.347,260.759,10.000,-133.420},
				{20004.423,260.759,10.000,-133.830},
				{20030.499,260.759,10.000,-134.230},
				{20056.575,260.759,10.000,-134.640},
				{20082.650,260.759,10.000,-135.040},
				{20108.726,260.759,10.000,-135.450},
				{20134.802,260.759,10.000,-135.850},
				{20160.878,260.759,10.000,-136.260},
				{20186.954,260.759,10.000,-136.660},
				{20213.030,260.759,10.000,-137.070},
				{20239.106,260.759,10.000,-137.470},
				{20265.182,260.759,10.000,-137.870},
				{20291.258,260.759,10.000,-138.280},
				{20317.334,260.759,10.000,-138.680},
				{20343.410,260.759,10.000,-139.080},
				{20369.486,260.759,10.000,-139.480},
				{20395.562,260.759,10.000,-139.880},
				{20421.638,260.759,10.000,-140.280},
				{20447.714,260.759,10.000,-140.680},
				{20473.790,260.759,10.000,-141.070},
				{20499.866,260.759,10.000,-141.470},
				{20525.942,260.759,10.000,-141.860},
				{20552.018,260.759,10.000,-142.260},
				{20578.093,260.759,10.000,-142.650},
				{20604.169,260.759,10.000,-143.040},
				{20630.245,260.759,10.000,-143.430},
				{20656.321,260.759,10.000,-143.810},
				{20682.397,260.759,10.000,-144.200},
				{20708.473,260.759,10.000,-144.580},
				{20734.549,260.759,10.000,-144.970},
				{20760.625,260.759,10.000,-145.350},
				{20786.701,260.759,10.000,-145.730},
				{20812.777,260.759,10.000,-146.100},
				{20838.853,260.759,10.000,-146.480},
				{20864.929,260.759,10.000,-146.850},
				{20891.005,260.759,10.000,-147.220},
				{20917.081,260.759,10.000,-147.590},
				{20943.157,260.759,10.000,-147.960},
				{20969.233,260.759,10.000,-148.320},
				{20995.309,260.759,10.000,-148.690},
				{21021.385,260.759,10.000,-149.050},
				{21047.460,260.759,10.000,-149.400},
				{21073.536,260.759,10.000,-149.760},
				{21099.612,260.759,10.000,-150.110},
				{21125.688,260.759,10.000,-150.460},
				{21151.764,260.759,10.000,-150.810},
				{21177.840,260.759,10.000,-151.160},
				{21203.916,260.759,10.000,-151.500},
				{21229.992,260.759,10.000,-151.840},
				{21256.068,260.759,10.000,-152.180},
				{21282.144,260.759,10.000,-152.520},
				{21308.220,260.759,10.000,-152.850},
				{21334.296,260.759,10.000,-153.190},
				{21360.372,260.759,10.000,-153.510},
				{21386.448,260.759,10.000,-153.840},
				{21412.524,260.759,10.000,-154.160},
				{21438.600,260.759,10.000,-154.480},
				{21464.676,260.759,10.000,-154.800},
				{21490.752,260.759,10.000,-155.120},
				{21516.827,260.759,10.000,-155.430},
				{21542.903,260.759,10.000,-155.740},
				{21568.979,260.759,10.000,-156.050},
				{21595.055,260.759,10.000,-156.350},
				{21621.131,260.759,10.000,-156.660},
				{21647.207,260.759,10.000,-156.960},
				{21673.283,260.759,10.000,-157.250},
				{21699.359,260.759,10.000,-157.550},
				{21725.435,260.759,10.000,-157.840},
				{21751.511,260.759,10.000,-158.130},
				{21777.587,260.759,10.000,-158.420},
				{21803.663,260.759,10.000,-158.700},
				{21829.739,260.759,10.000,-158.980},
				{21855.815,260.759,10.000,-159.260},
				{21881.891,260.759,10.000,-159.530},
				{21907.967,260.759,10.000,-159.810},
				{21934.043,260.759,10.000,-160.080},
				{21960.119,260.759,10.000,-160.350},
				{21986.195,260.759,10.000,-160.610},
				{22012.270,260.759,10.000,-160.870},
				{22038.346,260.759,10.000,-161.140},
				{22064.422,260.759,10.000,-161.390},
				{22090.498,260.759,10.000,-161.650},
				{22116.574,260.759,10.000,-161.900},
				{22142.650,260.759,10.000,-162.150},
				{22168.726,260.759,10.000,-162.400},
				{22194.802,260.759,10.000,-162.640},
				{22220.878,260.759,10.000,-162.890},
				{22246.954,260.759,10.000,-163.130},
				{22273.030,260.759,10.000,-163.360},
				{22299.106,260.759,10.000,-163.600},
				{22325.182,260.759,10.000,-163.830},
				{22351.258,260.759,10.000,-164.060},
				{22377.334,260.759,10.000,-164.290},
				{22403.410,260.759,10.000,-164.510},
				{22429.486,260.759,10.000,-164.740},
				{22455.562,260.759,10.000,-164.960},
				{22481.637,260.759,10.000,-165.180},
				{22507.713,260.759,10.000,-165.390},
				{22533.789,260.759,10.000,-165.610},
				{22559.865,260.759,10.000,-165.820},
				{22585.941,260.759,10.000,-166.030},
				{22612.017,260.759,10.000,-166.240},
				{22638.093,260.759,10.000,-166.440},
				{22664.169,260.759,10.000,-166.640},
				{22690.245,260.759,10.000,-166.840},
				{22716.321,260.759,10.000,-167.040},
				{22742.397,260.759,10.000,-167.240},
				{22768.473,260.759,10.000,-167.430},
				{22794.549,260.759,10.000,-167.620},
				{22820.625,260.759,10.000,-167.810},
				{22846.701,260.759,10.000,-168.000},
				{22872.777,260.759,10.000,-168.190},
				{22898.853,260.759,10.000,-168.370},
				{22924.929,260.759,10.000,-168.550},
				{22951.005,260.759,10.000,-168.730},
				{22977.080,260.759,10.000,-168.910},
				{23003.156,260.759,10.000,-169.080},
				{23029.232,260.759,10.000,-169.260},
				{23055.308,260.759,10.000,-169.430},
				{23081.384,260.759,10.000,-169.600},
				{23107.460,260.759,10.000,-169.770},
				{23133.536,260.759,10.000,-169.930},
				{23159.612,260.759,10.000,-170.100},
				{23185.688,260.759,10.000,-170.260},
				{23211.764,260.759,10.000,-170.420},
				{23237.840,260.759,10.000,-170.580},
				{23263.916,260.759,10.000,-170.730},
				{23289.992,260.759,10.000,-170.890},
				{23316.068,260.759,10.000,-171.040},
				{23342.144,260.759,10.000,-171.190},
				{23368.220,260.759,10.000,-171.340},
				{23394.296,260.759,10.000,-171.490},
				{23420.372,260.759,10.000,-171.640},
				{23446.447,260.759,10.000,-171.780},
				{23472.523,260.759,10.000,-171.920},
				{23498.599,260.759,10.000,-172.070},
				{23524.675,260.759,10.000,-172.210},
				{23550.751,260.759,10.000,-172.340},
				{23576.827,260.759,10.000,-172.480},
				{23602.903,260.759,10.000,-172.610},
				{23628.979,260.759,10.000,-172.750},
				{23655.055,260.759,10.000,-172.880},
				{23681.131,260.759,10.000,-173.010},
				{23707.207,260.759,10.000,-173.140},
				{23733.283,260.759,10.000,-173.260},
				{23759.359,260.759,10.000,-173.390},
				{23785.435,260.759,10.000,-173.510},
				{23811.511,260.759,10.000,-173.630},
				{23837.587,260.759,10.000,-173.760},
				{23863.663,260.759,10.000,-173.870},
				{23889.739,260.759,10.000,-173.990},
				{23915.815,260.759,10.000,-174.110},
				{23941.890,260.759,10.000,-174.220},
				{23967.966,260.759,10.000,-174.340},
				{23994.042,260.759,10.000,-174.450},
				{24020.118,260.759,10.000,-174.560},
				{24046.194,260.759,10.000,-174.670},
				{24072.270,260.759,10.000,-174.780},
				{24098.346,260.759,10.000,-174.880},
				{24124.422,260.759,10.000,-174.990},
				{24150.498,260.759,10.000,-175.090},
				{24176.574,260.759,10.000,-175.200},
				{24202.650,260.759,10.000,-175.300},
				{24228.726,260.759,10.000,-175.400},
				{24254.802,260.759,10.000,-175.500},
				{24280.878,260.759,10.000,-175.590},
				{24306.954,260.759,10.000,-175.690},
				{24333.030,260.759,10.000,-175.780},
				{24359.106,260.759,10.000,-175.880},
				{24385.182,260.759,10.000,-175.970},
				{24411.257,260.759,10.000,-176.060},
				{24437.333,260.759,10.000,-176.150},
				{24463.409,260.759,10.000,-176.240},
				{24489.485,260.759,10.000,-176.330},
				{24515.561,260.759,10.000,-176.410},
				{24541.637,260.759,10.000,-176.500},
				{24567.713,260.759,10.000,-176.580},
				{24593.789,260.759,10.000,-176.670},
				{24619.865,260.759,10.000,-176.750},
				{24645.941,260.759,10.000,-176.830},
				{24672.017,260.759,10.000,-176.910},
				{24698.093,260.759,10.000,-176.990},
				{24724.169,260.759,10.000,-177.060},
				{24750.245,260.759,10.000,-177.140},
				{24776.321,260.759,10.000,-177.210},
				{24802.397,260.759,10.000,-177.290},
				{24828.473,260.759,10.000,-177.360},
				{24854.549,260.759,10.000,-177.430},
				{24880.625,260.759,10.000,-177.500},
				{24906.700,260.759,10.000,-177.570},
				{24932.776,260.759,10.000,-177.640},
				{24958.852,260.759,10.000,-177.710},
				{24984.928,260.759,10.000,-177.770},
				{25011.004,260.759,10.000,-177.840},
				{25037.080,260.759,10.000,-177.900},
				{25063.156,260.759,10.000,-177.960},
				{25089.232,260.759,10.000,-178.030},
				{25115.308,260.759,10.000,-178.090},
				{25141.384,260.759,10.000,-178.150},
				{25167.460,260.759,10.000,-178.210},
				{25193.536,260.759,10.000,-178.260},
				{25219.612,260.759,10.000,-178.320},
				{25245.688,260.759,10.000,-178.380},
				{25271.764,260.759,10.000,-178.430},
				{25297.840,260.759,10.000,-178.480},
				{25323.916,260.759,10.000,-178.540},
				{25349.992,260.759,10.000,-178.590},
				{25376.067,260.759,10.000,-178.640},
				{25402.143,260.759,10.000,-178.690},
				{25428.219,260.759,10.000,-178.740},
				{25454.295,260.759,10.000,-178.790},
				{25480.371,260.759,10.000,-178.830},
				{25506.447,260.759,10.000,-178.880},
				{25532.523,260.759,10.000,-178.920},
				{25558.599,260.759,10.000,-178.970},
				{25584.675,260.759,10.000,-179.010},
				{25610.751,260.759,10.000,-179.050},
				{25636.827,260.759,10.000,-179.090},
				{25662.903,260.759,10.000,-179.130},
				{25688.979,260.759,10.000,-179.170},
				{25715.055,260.759,10.000,-179.210},
				{25741.131,260.759,10.000,-179.250},
				{25767.207,260.759,10.000,-179.280},
				{25793.283,260.759,10.000,-179.320},
				{25819.359,260.759,10.000,-179.350},
				{25845.435,260.759,10.000,-179.390},
				{25871.510,260.759,10.000,-179.420},
				{25897.586,260.759,10.000,-179.450},
				{25923.662,260.759,10.000,-179.480},
				{25949.738,260.759,10.000,-179.510},
				{25975.814,260.759,10.000,-179.540},
				{26001.890,260.759,10.000,-179.570},
				{26027.966,260.759,10.000,-179.600},
				{26054.042,260.759,10.000,-179.620},
				{26080.118,260.759,10.000,-179.650},
				{26106.194,260.759,10.000,-179.670},
				{26132.270,260.759,10.000,-179.700},
				{26158.346,260.759,10.000,-179.720},
				{26184.422,260.759,10.000,-179.740},
				{26210.498,260.759,10.000,-179.760},
				{26236.574,260.759,10.000,-179.780},
				{26262.650,260.759,10.000,-179.800},
				{26288.726,260.759,10.000,-179.820},
				{26314.802,260.759,10.000,-179.830},
				{26340.877,260.759,10.000,-179.850},
				{26366.953,260.759,10.000,-179.860},
				{26393.029,260.759,10.000,-179.880},
				{26419.105,260.759,10.000,-179.890},
				{26445.181,260.759,10.000,-179.900},
				{26471.257,260.759,10.000,-179.920},
				{26497.333,260.759,10.000,-179.930},
				{26523.409,260.759,10.000,-179.940},
				{26549.485,260.759,10.000,-179.940},
				{26575.561,260.759,10.000,-179.950},
				{26601.637,260.759,10.000,-179.960},
				{26627.713,260.759,10.000,-179.960},
				{26651.703,239.899,10.000,-179.970},
				{26673.607,219.038,10.000,-179.970},
				{26693.424,198.177,10.000,-179.980},
				{26711.156,177.316,10.000,-179.980},
				{26726.801,156.456,10.000,-179.980},
				{26740.361,135.595,10.000,-179.980},
				{26751.834,114.734,10.000,-179.980},
				{26761.222,93.873,10.000,-179.980},
				{26768.523,73.013,10.000,-179.980},
				{26773.738,52.152,10.000,-179.980},
				{26776.867,31.291,10.000,-179.980}		};

}