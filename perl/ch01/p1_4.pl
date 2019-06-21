#!/usr/bin/perl

# Page 26, problem 1.4.

use strict;
use warnings;

sub bisect_left {
    my ($val, @list) = @_;
    my $pos = 0;
    my $len = scalar @list;

    while ($pos < $len) {
        last if ($list[$pos] >= $val);
        $pos++;
    }

    return $pos;
}

sub smaller_counts {
    my @list = @_;

    my @seen   = ();
    my @counts = ();
    my @list2  = reverse @list;

    while (defined(my $val = shift @list2)) {
        my $pos = bisect_left($val, @seen);
        push @counts, $pos;
        splice @seen, $pos, 0, $val;
    }

    return reverse @counts;
}

my @result = @ARGV ? smaller_counts(@ARGV) : smaller_counts(3, 4, 9, 6, 1);
local $" = ', ';
print "[@result]\n";

exit;
