from datetime import datetime
from datetime import date

from .. utils import TranspileTestCase

class DateTests(TranspileTestCase):
	def test_today(self):
		self.assertCodeExecution("""
			from datetime import date
			print("ghdf")
			""")