#!/usr/bin/perl

# Page 22, problem 1.2.

use strict;
use warnings;

sub find_bounds {
    my @arr = @_;
    my ($left, $right) = ($#arr, 0);
    my ($max_seen, $min_seen);

    # Get the right bound:
    $max_seen = $arr[0];
    for my $i (1 .. $#arr) {
        $max_seen = ($max_seen < $arr[$i]) ? $arr[$i] : $max_seen;
        if ($arr[$i] < $max_seen) {
            $right = $i
        }
    }
    # Get the left bound:
    $min_seen = $arr[-1];
    for (my $i = ($#arr - 1); $i >= 0; $i--) {
        $min_seen = ($min_seen > $arr[$i]) ? $arr[$i] : $min_seen;
        if ($arr[$i] > $min_seen) {
            $left = $i;
        }
    }

    return ($left, $right);
}

my @bounds;

if (@ARGV) {
    @bounds = find_bounds(@ARGV);
} else {
    @bounds = find_bounds(qw(3 7 5 6 9));
}

print "(@bounds)\n";
